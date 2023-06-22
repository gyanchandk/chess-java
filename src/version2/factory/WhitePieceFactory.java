package version2.factory;

import version2.ChessPiece;
import version2.elements.WhiteBishop;
import version2.elements.WhiteKing;
import version2.elements.WhiteKnight;
import version2.elements.WhitePawn;
import version2.elements.WhiteQueen;
import version2.elements.WhiteRook;

public class WhitePieceFactory {

    public static ChessPiece getChessPiece(Piece piece){
        
        switch(piece){
            
            case PAWN:
                return new WhitePawn();
            
            case KNIGHT:
                return new WhiteKnight();
            
            case BISHOP:
                return new WhiteBishop();
            
            case ROOK:
                return new WhiteRook();
            
            case QUEEN:
                return new WhiteQueen();
            
            case KING:
                return new WhiteKing();


            default:
                break;
        }

        return null;
    }
    
}
