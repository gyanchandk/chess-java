package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class WhiteKnight extends Knight{

    public WhiteKnight(){
        team = Team.WHITE;
        pieceType=Piece.WHITE_KNIGHT;
    }
    

    @Override
    public String getName() {
        return "White Knight";
    }

    

}
