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
            
            case WHITE_PAWN:
                return new WhitePawn();
            
            case WHITE_KNIGHT:
                return new WhiteKnight();
            
            case WHITE_BISHOP:
                return new WhiteBishop();
            
            case WHITE_ROOK:
                return new WhiteRook();
            
            case WHITE_QUEEN:
                return new WhiteQueen();
            
            case WHITE_KING:
                return new WhiteKing();


            default:
                break;
        }

        return null;
    }
    
}
