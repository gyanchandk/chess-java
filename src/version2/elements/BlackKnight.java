package version2.elements;

import version2.Team;
import version2.factory.Piece;

public class BlackKnight extends Knight{

    public BlackKnight(){
        team = Team.BLACK;
        pieceType=Piece.BLACK_KNIGHT;
    }

    public String getName(){
        return "Black Knight";
    }
    
}
