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
            
            case BLACK_PAWN:
                return new BlackPawn();
            
            case BLACK_KNIGHT:
                return new BlackKnight();

            case BLACK_BISHOP:
                return new BlackBishop();
            
            case BLACK_ROOK:
                return new BlackRook();
            
            case BLACK_QUEEN:
                return new BlackQueen();
            
            case BLACK_KING:
                return new BlackKing();

            default:
                break;
        }

        return null;
    }
}
