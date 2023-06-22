package version2.elements;

import version2.Team;

public class WhiteKnight extends Knight{
    private String imagePath ="/images/whiteKnight.png";
    private int pieceValue;
    private Team team;

    public WhiteKnight(){
        pieceValue = 3;
        team = Team.WHITE;
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
        return "White Knight";
    }

    

}
