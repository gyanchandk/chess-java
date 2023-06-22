package version2.factory;

import version2.ChessPiece;
import version2.elements.BlackKnight;
import version2.elements.BlackPawn;

public class BlackPieceFactory {
    
    public static ChessPiece getChessPiece(Piece piece){

        switch(piece){
            
            case PAWN:
                return new BlackPawn();
            
            case KNIGHT:
                return new BlackKnight();

            default:
                break;
        }

        return null;
    }
}
