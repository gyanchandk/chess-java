package version2.elements;

import version2.ChessPiece;
import version2.Team;

public class BlackKnight extends ChessPiece{
    private int pieceValue;
    private Team team;

    public BlackKnight(){
        pieceValue = 3;
        team = Team.BLACK;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public Team getTeam() {
        return team;
    }

    public String getName(){
        return "Black Knight";
    }
    
    public void drawHints(int row,int col){

    }
}
