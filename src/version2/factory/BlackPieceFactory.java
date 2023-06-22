package version2.factory;

import version2.ChessPiece;
import version2.elements.BlackBishop;
import version2.elements.BlackKing;
import version2.elements.BlackKnight;
import version2.elements.BlackPawn;
import version2.elements.BlackQueen;
import version2.elements.BlackRook;

public class BlackPieceFactory {
    
    public static ChessPiece getChessPiece(Piece piece){

        switch(piece){
            
            case PAWN:
                return new BlackPawn();
            
            case KNIGHT:
                return new BlackKnight();

            case BISHOP:
                return new BlackBishop();
            
            case ROOK:
                return new BlackRook();
            
            case QUEEN:
                return new BlackQueen();
            
            case KING:
                return new BlackKing();

            default:
                break;
        }

        return null;
    }
}
