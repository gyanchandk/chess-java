package version2.elements;

// import version2.HightLightLayer;
// import version2.PieceTracker;
import version2.Team;

public class BlackBishop extends Bishop{
    
    private String imagePath ="/images/bb.png";
    private int pieceValue;
    private Team team;

    public BlackBishop(){
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
        return "Black Bishop";
    }

}

