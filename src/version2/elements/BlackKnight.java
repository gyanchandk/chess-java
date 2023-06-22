package version2.elements;

import version2.Team;

public class BlackKnight extends Knight{
    private String imagePath ="/images/bn.png";
    private int pieceValue;
    private Team team;

    public BlackKnight(){
        pieceValue = 3;
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
        return "Black Knight";
    }
    
}
