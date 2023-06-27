package version2.elements;

import version2.factory.Piece;

public class PieceImageFactory {

    private static final String whitePawn = "/images/wp.png";
    private static final String blackPawn = "/images/bp.png";

    private static final String whiteKnight = "/images/whiteKnight.png";
    private static final String blackKnight = "/images/bn.png";

    private static final String whiteBishop = "/images/whiteBishop.png";
    private static final String blackBishop = "/images/bb.png";

    private static final String whiteRook = "/images/whiteRook.png";
    private static final String blackRook = "/images/br.png";

    private static final String whiteQueen = "/images/wq.png";
    private static final String blackQueen = "/images/bq.png";

    private static final String whiteKing = "/images/wk.png";
    private static final String blackKing = "/images/bk.png";


    public static String getImagepath(Piece piece){
        switch(piece){
            case WHITE_PAWN:
                return whitePawn;
            
            case BLACK_PAWN:
                return blackPawn;

            case WHITE_KNIGHT:
                return whiteKnight;
            
            case BLACK_KNIGHT:
                return blackKnight;
            
            case WHITE_BISHOP:
                return whiteBishop;
            
            case BLACK_BISHOP:
                return blackBishop;
            
            case WHITE_ROOK:
                return whiteRook;
            
            case BLACK_ROOK:
                return blackRook;
            
            case WHITE_QUEEN:
                return whiteQueen;
            
            case BLACK_QUEEN:
                return blackQueen;

            case WHITE_KING:
                return whiteKing;
            
            case BLACK_KING:
                return blackKing;
                
            default:
                return null;
            
        }
    }

    
}
