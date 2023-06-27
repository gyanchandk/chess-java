package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.EnvUtility;
import version2.Game;
import version2.Log;
import version2.Team;
import version2.factory.Piece;

public class BlackPawn extends Pawn{

    public BlackPawn(){
        team = Team.BLACK;
        pieceType= Piece.BLACK_PAWN;
    }


    public String getName(){
        return "Black Pawn";
    }


    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        Log.info(this, "Moves requested ");
        ArrayList<Cell> moves = new ArrayList<>();

        boolean oneMoveAhead=false;

        if(EnvUtility.check(row+1, col)){
            if(pieceTracker.getInfo(row+1, col)==null){
                moves.add(new Cell(row+1, col));
                oneMoveAhead=true;
            }
        }

        if(EnvUtility.check(row+2, col)){
            if(row==2 && oneMoveAhead && pieceTracker.getInfo(row+2, col)==null){
                moves.add(new Cell(row+2, col));
            }
        }
        
        if(EnvUtility.check(row+1, col-1)){
            if(isOpponentAt(this,row+1,col-1)){
                moves.add(new Cell(row+1, col-1));
            }
        }
            
        
        if(EnvUtility.check(row+1, col+1)){
            if(isOpponentAt(this,row+1, col+1)){
                moves.add(new Cell(row+1, col+1));
            }
        }

        if(row==5){
            checkForEnpassant(row, col);
        }
    

        if(Game.getLeftEnpassant()){
            moves.add(new Cell(row+1, col-1));
        }

        if(Game.getRightEnpassant()){
            moves.add(new Cell(row+1, col+1));
        }

        return moves;
    }

    

    

}
