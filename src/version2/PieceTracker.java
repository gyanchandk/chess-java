package version2;

import java.util.ArrayList;

import version2.elements.BlackKing;
import version2.elements.King;
import version2.elements.WhiteKing;

public class PieceTracker {
    private ChessPiece  tracker[] = new ChessPiece[64];
    private static PieceTracker instance = new PieceTracker();
    private ArrayList<Coordinate> permissibleCells = new ArrayList<>();
    private GameControl control = GameControl.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();

    private Coordinate blackKingCoordinate;
    private Coordinate whiteKingCoordinate;

    private  boolean virtual=false;

    private PieceTracker(){
        blackKingCoordinate = new Coordinate(1, 5);
        whiteKingCoordinate = new Coordinate(8, 5);
    }
    public static PieceTracker getInstance(){
        return instance;

    }

    public void initializeMovesStatus(){
        for(ChessPiece piece:tracker){
            if(piece!=null){
                piece.resetMovedStatus();
                
            }
        }
        
    }

    private void checkIfKingMovement(int row,int col, ChessPiece piece){

        if(piece==null)return;

        if(piece.getClass().equals(new BlackKing().getClass())){
                setBlackKingCoordinate(new Coordinate(row, col));

                if(virtual)return;

                if(Math.abs(5-col)==2){
                    System.out.println("black king castling attempted");
                    
                    new King().makeRookMoveForCastleing(row, col);
                    control.changeTurn();

                    
                }
            }
            else if(piece.getClass().equals(new WhiteKing().getClass())){
                setWhiteKingCoordinate(new Coordinate(row, col));

                

                if(virtual)return;

                if(Math.abs(5-col)==2){
                    System.out.println("white king castling attempted");
                
                    new King().makeRookMoveForCastleing(row, col);
                    control.changeTurn();
                }
            }
    }

    public boolean updatePiecePos(int row,int col,ChessPiece piece){
        virtual =true;
        
        //this is called when board is set initially.
        int index = EnvUtility.getIndex(row, col);
        tracker[index]=piece;

        checkIfKingMovement(row, col, piece);
        return true;
    }

    public boolean updatePiecePos(int row, int col,int newRow,int newCol,ChessPiece piece){
        virtual = false;

        //this is called for moves on board after start
        if(piece==null){
            //BUG:
            System.out.println("Error case ! piece can't be null");
            //return false;
        }

        int oldPosition = EnvUtility.getIndex(row, col);
        tracker[oldPosition]=null;

        int newPosition = EnvUtility.getIndex(newRow, newCol);
        tracker[newPosition]=piece;


        piece.setMoved();
        control.changeTurn();

        checkIfKingMovement(newRow, newCol, piece);

        

        return true;

    }


    public ChessPiece getInfo(int row,int col){
        int index=EnvUtility.getIndex(row, col);
        return tracker[index];
    }

    public void updatePermissibleCells(ArrayList<Coordinate> cells ){
        permissibleCells = cells;
    }

    public ArrayList<Coordinate> getPermissibleCells(){
        return permissibleCells;
    }

    public void getKingsPosition(){
        System.out.println("white-king:"+whiteKingCoordinate);
        System.out.println("black-king:"+blackKingCoordinate);
    }

    public Coordinate getWhiteKingCoordinate() {
        return whiteKingCoordinate;
    }
    
    public Coordinate getBlackKingCoordinate() {
        return blackKingCoordinate;
    }

    private void setBlackKingCoordinate(Coordinate blackKingCoordinate) {
        this.blackKingCoordinate = blackKingCoordinate;
    }

    private void setWhiteKingCoordinate(Coordinate whiteKingCoordinate) {
        this.whiteKingCoordinate = whiteKingCoordinate;
    }

    public ChessPiece[] getTracker() {
        return tracker;
    }

    
}
