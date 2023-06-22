package version2.elements;

import version2.Team;

public class BlackRook extends Rook{
    
    private String imagePath ="/images/br.png";
    private int pieceValue;
    private Team team;

    public BlackRook(){
        pieceValue = 5;
        team=Team.BLACK;
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
        return "Black Rook";
    }

}