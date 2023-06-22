package version2.elements;

import version2.Team;

public class WhiteBishop extends Bishop{
    
    private String imagePath ="/images/whiteBishop.png";
    private int pieceValue;
    private Team team;

    public WhiteBishop(){
        pieceValue = 5;
        team=Team.WHITE;
        loadImage(imagePath);
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String getName() {
        return "White Bishop";
    }
}
