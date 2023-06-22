package version2.elements;

import version2.Team;

public class BlackKing extends King{
    
    private String imagePath ="/images/bk.png";
    private int pieceValue;
    private Team team;

    public BlackKing(){
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
        return "Black king";
    }

}

