package version2.elements;

// import version2.HightLightLayer;
// import version2.PieceTracker;
import version2.Team;
import version2.factory.Piece;

public class BlackBishop extends Bishop{
    
    public BlackBishop(){
        team=Team.BLACK;
        pieceType=Piece.BLACK_BISHOP;
        
    }

    @Override
    public String getName() {
        return "Black Bishop";
    }

}

