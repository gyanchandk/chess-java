package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class WhiteQueen extends Queen{

    public WhiteQueen(){
        team=Team.WHITE;
        pieceType=Piece.WHITE_QUEEN;
    }

    @Override
    public String getName() {
        return "White Queen";
    }

}
