package version2.elements;

import version2.Team;

public class WhiteQueen extends Queen{
    
    private String imagePath ="/images/wq.png";
    private int pieceValue;
    private Team team;

    public WhiteQueen(){
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
        return "White Queen";
    }

}
