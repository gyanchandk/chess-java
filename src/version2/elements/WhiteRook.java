package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class WhiteRook extends Rook{

    public WhiteRook(){
        team=Team.WHITE;
        pieceType = Piece.WHITE_ROOK;
        
    }

    @Override
    public String getName() {
        return "White Rook";
    }
    
}
