package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class BlackPawn extends Pawn{
    private String imagePath ="/images/bp.png";
    private HightLightLayer hl = HightLightLayer.getInstance();
    PieceTracker pt = PieceTracker.getInstance();
    private int pieceValue;
    private Team team;
    

    public BlackPawn(){
        hasMoved = false;
        pieceValue = 1;
        team = Team.BLACK;
        loadImage(imagePath);
        
    }


    public int getPieceValue() {
        return pieceValue;
    }
    public Team getTeam() {
        return team;
    }

    public String getName(){
        return "Black Pawn";
    }
    
    public void drawHints(int row,int col){
        ArrayList<Coordinate> moves= new ArrayList<>();

        boolean oneMoveAhead=false;

        if(EnvUtility.check(row+1, col)){
            if(pt.getInfo(row+1, col)==null){
                moves.add(new Coordinate(row+1, col));
                oneMoveAhead=true;
            }
        }
            
        
        if(EnvUtility.check(row+2, col)){
            if(!hasMoved && oneMoveAhead && pt.getInfo(row+2, col)==null){
                moves.add(new Coordinate(row+2, col));
            }
        }
            
        
        if(EnvUtility.check(row+1, col-1)){
            if(isOpponent(row+1, col-1)){
                moves.add(new Coordinate(row+1, col-1));
            }
        }
            
        
        if(EnvUtility.check(row+1, col+1)){
            if(isOpponent(row+1, col+1)){
                moves.add(new Coordinate(row+1, col+1));
            }
        }

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);

    }

    public boolean isOpponent(int row,int col){
        ChessPiece piece = pt.getInfo(row, col);
        
        if(piece==null)return false;

        Team targetTeam = piece.getTeam();

        if(targetTeam!=Team.BLACK)return true;

        return false;
    }
    
}
