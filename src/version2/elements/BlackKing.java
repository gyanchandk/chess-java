package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class BlackKing extends King{
    
    public BlackKing(){
        team=Team.BLACK;
        pieceType=Piece.BLACK_KING;
    }

    @Override
    public String getName() {
        return "Black king";
    }

}

