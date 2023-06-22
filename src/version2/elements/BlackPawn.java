package version2.elements;

import version2.ChessPiece;
//import version2.HightLightLayer;
import version2.Team;

public class BlackPawn extends ChessPiece{
    private String imagePath ="/images/bp.png";
   // private HightLightLayer hl = HightLightLayer.getInstance();
    private int pieceValue;
    private Team team;

    public BlackPawn(){
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

    }
    
}
