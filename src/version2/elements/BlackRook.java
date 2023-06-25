package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class BlackRook extends Rook{
    
    public BlackRook(){
        team=Team.BLACK;
        pieceType=Piece.BLACK_ROOK;
        
    }

    @Override
    public String getName() {
        return "Black Rook";
    }

}