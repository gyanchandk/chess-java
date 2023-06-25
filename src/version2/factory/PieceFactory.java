package version2.factory;

import version2.ChessPiece;

public class PieceFactory {
    
    public static ChessPiece getPiece(Piece pieceType){

        ChessPiece piece = WhitePieceFactory.getChessPiece(pieceType);

        if(piece==null){
            piece = BlackPieceFactory.getChessPiece(pieceType);
        }

        return piece;
    }
}
