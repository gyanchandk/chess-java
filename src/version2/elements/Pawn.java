package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.Game;
import version2.Log;

public class Pawn extends ChessPiece{

    protected int pieceValue = 1;

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public  ArrayList<Cell> getMovesFor(int row, int col){
        throw new UnsupportedOperationException("Unimplemented method 'getMovesFor'");
    }

    public void checkForEnpassant(int row,int col){

        Cell cell;
        Log.info(this, "checkfor enpassant called");

        //check for left pawn
        if(checkForAdjacentPawn(row, col-1)){

            Log.info(this, "En--- passant applicable with left pawn");
            Game.setLeftEnpassant(true);
        
        }else{
            Game.setLeftEnpassant(false);
            Log.info(this, "En--- passant applicable with left pawn");
        }

        //check for right pawn
        if(checkForAdjacentPawn(row, col+1)){
            Log.info(this, "En--- passant applicable with left pawn");
            Game.setRightEnPassant(true);
            
        }else{
            Game.setRightEnPassant(false);
            Log.info(this, "En--- passant applicable with left pawn");
            
        }

        
        
    }

    public boolean checkForAdjacentPawn(int row,int col){

        Log.info(this, Game.getRecentMoveMadeTo()+" ");

        if(Game.getRecentMoveMadeTo()==null)return false;

        if(!Game.getRecentMoveMadeTo().isequalto(new Cell(row, col))){
            return false;
        }

        ChessPiece piece = pieceTracker.getInfo(row, col);

        if(piece==null){
            Log.error(this, "This case will never arise...........");
            return false;
        }

        
        if(piece instanceof Pawn && piece.getTeam()!=this.getTeam() ){
            if(piece.getMoveCount()==1){
                return true;
            }
        }

        return true;

    }
    

}
