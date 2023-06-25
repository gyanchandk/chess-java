package version2.elements;


import version2.Team;
import version2.factory.Piece;

public class BlackQueen extends Queen{

    public BlackQueen(){
        team=Team.BLACK;
        pieceType=Piece.BLACK_QUEEN;
    }

    @Override
    public String getName() {
        return "Black Queen";
    }
}
