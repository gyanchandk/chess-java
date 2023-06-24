package version2;

import java.util.ArrayList;

import version2.elements.BlackBishop;
import version2.elements.BlackKnight;
import version2.elements.BlackPawn;
import version2.elements.BlackQueen;
import version2.elements.BlackRook;
import version2.elements.WhiteBishop;
import version2.elements.WhiteKnight;
import version2.elements.WhitePawn;
import version2.elements.WhiteQueen;
import version2.elements.WhiteRook;

public class ChessRules {

    private static ChessRules instance = new ChessRules();
    private PieceTracker pt = PieceTracker.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();
    private boolean whiteKingInCheck = false;
    private boolean blackKingInCheck = false;

    private ChessRules(){

    }
    public static ChessRules getInstance(){
        return instance;
    }



    public boolean validate(int newRow,int newCol){

        ArrayList<Coordinate> cells = pt.getPermissibleCells();

        for(Coordinate c:cells){
            //System.out.println(c.getX()+","+c.getY());

            if(newRow == c.getX() && newCol == c.getY()){
                System.out.println("rules/validate"+ c+ " is permitted");
                return true;
            }
        }
        
        System.out.println("rules/validate: this move is not in permissible cells");
        return false;
    }

    public boolean checkForSameTeam(int row,int col,int newRow,int newCol){

        if(pt.getInfo(row, col)==null){
            System.out.println("team check called for:"+row+","+col+ "  ERROR!!!!!!");
        }

        Team team = pt.getInfo(row, col).getTeam();

        if(pt.getInfo(newRow, newCol)==null){
            return true;
        }
        else{

            Team targetTeam = pt.getInfo(newRow, newCol).getTeam();
            if(team !=targetTeam){
                return true;
            }
        }

        return false;
    }



    public void moveConsequence(ChessPiece piece,int row,int col){

        isThisMoveLegal(piece, row, col);

        if(whiteKingInCheck){
            hl.highlightKingSquareWhenChecked(pt.getWhiteKingCoordinate());
        }else if(blackKingInCheck){
            hl.highlightKingSquareWhenChecked(pt.getBlackKingCoordinate());
        }else{
            hl.highlightKingSquareWhenChecked(null);
        }
    }

    public boolean isThisMoveLegal(ChessPiece piece,int row,int col){

        
        //returning true means move is legal:king is not in check or discoved check;

        if(piece==null){
            System.out.println("Error case : piece should not be null!!!!");
            return false;
        }

        Team currTeam = piece.getTeam();

            if(isWhiteKingChecked(pt.getWhiteKingCoordinate())){

                if(currTeam==Team.WHITE){
                    System.out.println("Either it is pinned piece /king is in check");
                    return false;
                }

                //white king was checked and current move does not take care
                if(whiteKingInCheck){
                    System.out.println("!!!!!!!!!!Illegal move : white king is in check");
                    return false;
                }

                //hl.highlightKingSquareWhenChecked(pt.getWhiteKingCoordinate());
                //System.out.println("called for white-king coor"+ whiteKingCoordinate+"to highlight");
                whiteKingInCheck = true;
                System.out.println("white king is checked ");

            }
            else{
    
                whiteKingInCheck = false;
            }

            if(isBlackKingChecked(pt.getBlackKingCoordinate())){

                if(currTeam==Team.BLACK){
                    System.out.println("Either it is pinned piece /king is in check");
                    return false;
                }

                if(blackKingInCheck){
                    System.out.println("!!!!!!!!!!Illegal move : BLACK king is in check");
                    return false;
                }
                //hl.highlightKingSquareWhenChecked(pt.getBlackKingCoordinate());
                System.out.println("black king is checked ");
                blackKingInCheck = true;
            }else{
                
                blackKingInCheck =false;
            }
            
            

        return true;


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
            ChessPiece currPiece = pt.getInfo(c.getX(), c.getY());

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
