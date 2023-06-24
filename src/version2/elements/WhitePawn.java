package version2.elements;


import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.Team;

public class WhitePawn extends Pawn{
    private String imagePath ="/images/wp.png";
    private int pieceValue;
    private Team team;
    

    public WhitePawn(){
        hasMoved=false;
        pieceValue = 1;
        team = Team.WHITE;
        super.loadImage(imagePath);
    }


    public int getPieceValue() {
        return pieceValue;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String getName() {
        return "White Pawn";
    }

    public void getMoves(int row,int col,ArrayList<Coordinate> moves){
        boolean oneMoveAhead=false;

        if(EnvUtility.check(row-1, col)){
            if(pt.getInfo(row-1, col)==null){
                moves.add(new Coordinate(row-1, col));
                oneMoveAhead=true;
            }
        }

            
        
        if(EnvUtility.check(row-2, col)){
            if(!hasMoved && oneMoveAhead && pt.getInfo(row-2, col)==null){
                moves.add(new Coordinate(row-2, col));
            }
        }
        
        if(EnvUtility.check(row-1, col-1)){
            if(isOpponent(row-1,col-1)){
                moves.add(new Coordinate(row-1, col-1));
            }
        }
            
        
        if(EnvUtility.check(row-1, col+1)){
            if(isOpponent(row-1, col+1)){
                moves.add(new Coordinate(row-1, col+1));
            }
        }

    }

    public boolean isOpponent(int row,int col){
        ChessPiece piece = pt.getInfo(row, col);
        
        if(piece==null)return false;

        Team targetTeam = piece.getTeam();

        if(targetTeam!=Team.WHITE)return true;

        return false;
    }
    
}
