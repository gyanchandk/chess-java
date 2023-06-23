package version2;

import java.util.ArrayList;

import version2.elements.BlackBishop;
import version2.elements.BlackKing;
import version2.elements.WhiteBishop;
import version2.elements.WhiteKing;

public class PieceTracker {
    private ChessPiece  tracker[] = new ChessPiece[64];
    private static PieceTracker instance = new PieceTracker();
    private ArrayList<Coordinate> permissibleCells = new ArrayList<>();
    private GameControl control = GameControl.getInstance();

    private boolean  gameHasStarted=false;
    private Coordinate blackKingCoordinate;
    private Coordinate whiteKingCoordinate;



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
        gameHasStarted = true;
        
    }

    public void updatePiecePos(int row, int col, ChessPiece piece){
        int index = EnvUtility.getIndex(row, col);

        if(piece!=null){
            piece.setMoved();
            control.changeTurn();
        }
        
        tracker[index]=piece;

        if(gameHasStarted){
            getKingsPosition();
            if(piece instanceof BlackKing){
                blackKingCoordinate = new Coordinate(row, col);
            }
            else if(piece instanceof WhiteKing){
                whiteKingCoordinate= new Coordinate(row, col);
            }


            isKingChecked(whiteKingCoordinate);

        }

        

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

    public void  isKingChecked(Coordinate kingCoordinate){

        System.out.println("game has started checking if white king is checked");
        int row= kingCoordinate.getX();
        int col= kingCoordinate.getY();

        //assume it is white king
        ArrayList<Coordinate> moves = new ArrayList<>();

        WhiteBishop whiteBishop = new WhiteBishop();
        whiteBishop.getBishopMoves(row, col, moves);

        //check if king is inline of bishop
        checkIfKingInRange(kingCoordinate,new BlackBishop(),moves);

        


    }

    public void checkIfKingInRange(Coordinate kCoordinate,ChessPiece piece,ArrayList<Coordinate> moves){
        for(Coordinate c:moves){

           
            ChessPiece currPiece = getInfo(c.getX(), c.getY());

            if(currPiece==null){
                System.out.println("null at"+c);
                continue;
            }

            System.out.println(c+" piece:"+currPiece.getClass()+",target:"+piece.getClass());

            if(currPiece.getClass().equals(piece.getClass())){
                System.out.println("king is checked by:"+piece.getName());
            }
            
        }

    }
}
