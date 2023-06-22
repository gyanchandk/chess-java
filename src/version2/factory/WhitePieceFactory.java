package version2.factory;

import version2.ChessPiece;
import version2.elements.WhiteKnight;
import version2.elements.WhitePawn;

public class WhitePieceFactory {

    public static ChessPiece getChessPiece(Piece piece){
        
        switch(piece){
            
            case PAWN:
                return new WhitePawn();
            
            case KNIGHT:
                return new WhiteKnight();

            default:
                break;
        }

        return null;
    }
    
}
