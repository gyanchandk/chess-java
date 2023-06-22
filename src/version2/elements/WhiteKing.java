package version2.elements;


import version2.Team;

public class WhiteKing extends King{
    
    private String imagePath ="/images/wk.png";
    private int pieceValue;
    private Team team;

    public WhiteKing(){
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
        return "White King";
    }

}

