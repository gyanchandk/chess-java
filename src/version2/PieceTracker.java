package version2;

import java.util.ArrayList;

import version2.elements.BlackBishop;
import version2.elements.BlackKing;
import version2.elements.BlackKnight;
import version2.elements.BlackPawn;
import version2.elements.BlackQueen;
import version2.elements.BlackRook;
import version2.elements.WhiteBishop;
import version2.elements.WhiteKing;
import version2.elements.WhiteKnight;
import version2.elements.WhitePawn;
import version2.elements.WhiteQueen;
import version2.elements.WhiteRook;

public class PieceTracker {
    private ChessPiece  tracker[] = new ChessPiece[64];
    private static PieceTracker instance = new PieceTracker();
    private ArrayList<Coordinate> permissibleCells = new ArrayList<>();
    private GameControl control = GameControl.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();

    private boolean  gameHasStarted=false;
    private Coordinate blackKingCoordinate;
    private Coordinate whiteKingCoordinate;

    private boolean whiteKingInCheck=false;
    private boolean blackKingInCheck=false;

    private Coordinate prevState;



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
    public boolean updatePiecePos(int row,int col,ChessPiece piece){
        //this is called when board is set initially.
        int index = EnvUtility.getIndex(row, col);
        tracker[index]=piece;
        return true;
    }

    public boolean updatePiecePos(int row, int col,int newRow,int newCol,ChessPiece piece){

        //this is called for moves on board after start 
        if(piece==null){
            System.out.println("Error case ! piece can't be null");
            return false;
        }
        ChessPiece targetPiece = getInfo(newRow, newCol);

        int oldPosition = EnvUtility.getIndex(row, col);
        tracker[oldPosition]=null;

        int newPosition = EnvUtility.getIndex(newRow, newCol);
        tracker[newPosition]=piece;


        if(!handleKingCheckScenario(piece, newRow, newCol)){
            //revert back
            tracker[newPosition]=targetPiece;
            tracker[oldPosition]=piece;

            return false;
        }

        piece.setMoved();
        control.changeTurn();
        
        return true;

    }

    public boolean handleKingCheckScenario(ChessPiece piece,int row,int col){

        //returning true means move is legal:king is not in check or discoved check;

        if(piece==null){
            System.out.println("Error case : piece should not be null!!!!");
            return false;
        }

        Team currTeam = piece.getTeam();

        
            getKingsPosition();
            if(piece.getClass().equals(new BlackKing().getClass())){
                blackKingCoordinate = new Coordinate(row, col);
            }
            else if(piece.getClass().equals(new WhiteKing().getClass())){
                whiteKingCoordinate= new Coordinate(row, col);
            }

            if(isWhiteKingChecked(whiteKingCoordinate)){

                if(currTeam==Team.WHITE){
                    System.out.println("Either it is pinned piece /king is in check");
                    return false;
                }

                //white king was checked and current move does not take care
                if(whiteKingInCheck){
                    System.out.println("!!!!!!!!!!Illegal move : white king is in check");
                    return false;
                }

                hl.highlightKingSquareWhenChecked(whiteKingCoordinate);
                System.out.println("called for white-king coor"+ whiteKingCoordinate+"to highlight");
                whiteKingInCheck = true;

            }
            else{
    
                whiteKingInCheck = false;
            }

            if(isBlackKingChecked(blackKingCoordinate)){

                if(currTeam==Team.BLACK){
                    System.out.println("Either it is pinned piece /king is in check");
                    return false;
                }

                if(blackKingInCheck){
                    System.out.println("!!!!!!!!!!Illegal move : BLACK king is in check");
                    return false;
                }
                hl.highlightKingSquareWhenChecked(blackKingCoordinate);
                blackKingInCheck = true;
            }else{
                
                blackKingInCheck =false;
            }
            
            if(!whiteKingInCheck && !blackKingInCheck){
                hl.highlightKingSquareWhenChecked(null);

            }

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

    public boolean isBlackKingChecked(Coordinate c){

        int row= c.getX();
        int col= c.getY();

        if(isCheckedBy(new BlackKnight(), row, col, new WhiteKnight()))
            return true;

        if(isCheckedBy(new BlackBishop(), row, col, new WhiteBishop()))
            return true;
        
        if(isCheckedBy(new BlackRook(), row, col, new WhiteRook()))
            return true;
        
        if(isCheckedBy(new BlackQueen(), row, col, new WhiteQueen()))
            return true;
        
        if(isCheckedBy(new BlackPawn(), row, col, new WhitePawn()))
            return true;

        return false;

    }

    public boolean  isWhiteKingChecked(Coordinate c){

        int row= c.getX();
        int col= c.getY();

        if(isCheckedBy(new WhiteKnight(), row, col, new BlackKnight()))
            return true;

        if(isCheckedBy(new WhiteBishop(), row, col,new BlackBishop()))
            return true;

        if(isCheckedBy(new WhiteRook(), row, col, new BlackRook()))
            return true;

        if(isCheckedBy(new WhiteQueen(), row, col, new BlackQueen()))
            return true;
        
        if(isCheckedBy(new WhitePawn(), row, col, new BlackPawn()))
            return true;
        
        return false;

    }

    public boolean isCheckedBy(ChessPiece piece,int row,int col,ChessPiece targetPiece){
        ArrayList<Coordinate> moves = new ArrayList<>();

        piece.getMoves(row,col,moves);
        return checkIfKingInRange(targetPiece, moves);

    }

    public boolean checkIfKingInRange(ChessPiece piece,ArrayList<Coordinate> moves){
        for(Coordinate c:moves){
            ChessPiece currPiece = getInfo(c.getX(), c.getY());

            if(currPiece==null){
                continue;
            }

            if(currPiece.getClass().equals(piece.getClass())){
                System.out.println("king is checked by:"+piece.getName());
                return true;
            }
            
        }

        return false;


    }
}
