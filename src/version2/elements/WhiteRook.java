package version2.elements;

import version2.Team;

public class WhiteRook extends Rook{
    
    private String imagePath ="/images/whiteRook.png";
    private int pieceValue;
    private Team team;

    public WhiteRook(){
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
        return "White Rook";
    }
    
}
