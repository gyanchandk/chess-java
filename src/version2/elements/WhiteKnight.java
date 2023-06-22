package version2.elements;

import version2.ChessPiece;
import version2.Team;

public class WhiteKnight extends ChessPiece{
    private int pieceValue;
    private Team team;

    public WhiteKnight(){
        pieceValue = 3;
        team = Team.WHITE;
    }
    
    public int getPieceValue() {
        return pieceValue;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String getName() {
        return "White Knight";
    }

    @Override
    public void drawHints(int row, int col) {
        
    }
    
}
