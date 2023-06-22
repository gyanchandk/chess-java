package version2.elements;


import version2.Team;

public class BlackQueen extends Queen{
    
    private String imagePath ="/images/bq.png";
    private int pieceValue;
    private Team team;

    public BlackQueen(){
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
        return "Black Queen";
    }
}
