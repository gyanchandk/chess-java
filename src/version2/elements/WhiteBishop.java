package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class WhiteBishop extends Bishop{

    public WhiteBishop(){
        team=Team.WHITE;
        pieceType=Piece.WHITE_BISHOP;
    }

    @Override
    public String getName() {
        return "White Bishop";
    }
}
