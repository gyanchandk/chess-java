package version2.elements;


import version2.Team;
import version2.factory.Piece;

public class WhiteKing extends King{

    public WhiteKing(){
        team=Team.WHITE;
        pieceType=Piece.WHITE_KING;
    }


    @Override
    public String getName() {
        return "White King";
    }

}

