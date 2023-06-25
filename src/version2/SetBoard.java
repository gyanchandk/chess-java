package version2;

import version2.factory.BlackPieceFactory;
import version2.factory.Piece;
import version2.factory.PieceFactory;
import version2.factory.WhitePieceFactory;
import version2.rules.Tester;

public class SetBoard {

    private PieceTracker pieceTracker;

    SetBoard(){
        this.pieceTracker = Game.getPieceTracker();
        //addAllPieces();
        testPosition();
        //testPawnMoves();

        Tester.check();
    }

    private void setPieceOnBoard(Piece pieceType, int row, int col){

        ChessPiece piece = PieceFactory.getPiece(pieceType);
        pieceTracker.setInitialPosition(piece, row, col);
        
    }

    public void testPawnMoves(){
    }

    public void testPosition(){
        setPieceOnBoard(Piece.BLACK_KING, 5, 5);
        setPieceOnBoard(Piece.WHITE_KING, 4, 4);
        setPieceOnBoard(Piece.WHITE_QUEEN, 7, 6);
        setPieceOnBoard(Piece.BLACK_BISHOP, 1, 5);
        setPieceOnBoard(Piece.BLACK_ROOK, 8, 3);
        setPieceOnBoard(Piece.BLACK_KNIGHT, 4, 5);
        
    }

    private void addAllPieces(){
        //addPawns();
        // addKnights();
        // addBishops();
        // addRooks();
        // addQueens();
        // addKings();

    }
    public void addPawns(){
        for(int col=1;col<=8;col++){
            setPieceOnBoard(Piece.WHITE_PAWN, 7, col);
            setPieceOnBoard(Piece.BLACK_PAWN, 2, col);
        }

    }

    public void addToChessboard(ChessPiece piece,int row,int col){

        pieceTracker.updatePiecePos(5, 5, row, col, piece);
    
    }

    public void addKnights(){
        ChessPiece wbKnight = WhitePieceFactory.getChessPiece(Piece.KNIGHT);
        addToChessboard(wbKnight, 8, 2);

        ChessPiece wgKnight = WhitePieceFactory.getChessPiece(Piece.KNIGHT);
        addToChessboard(wgKnight, 8, 7);

        ChessPiece bbKnight = BlackPieceFactory.getChessPiece(Piece.KNIGHT);
        addToChessboard(bbKnight, 1, 2);

        ChessPiece bgKnight = BlackPieceFactory.getChessPiece(Piece.KNIGHT);
        addToChessboard(bgKnight, 1, 7);


    }

    public void addBishops(){
        ChessPiece wcBishop = WhitePieceFactory.getChessPiece(Piece.BISHOP);
        addToChessboard(wcBishop, 8, 3);

        ChessPiece wfBishop = WhitePieceFactory.getChessPiece(Piece.BISHOP);
        addToChessboard(wfBishop, 8, 6);

        ChessPiece bcBishop = BlackPieceFactory.getChessPiece(Piece.BISHOP);
        addToChessboard(bcBishop, 1, 3);

        ChessPiece bfBishop = BlackPieceFactory.getChessPiece(Piece.BISHOP);
        addToChessboard(bfBishop, 1, 6);

    }

    public void addRooks(){
        ChessPiece waRook = WhitePieceFactory.getChessPiece(Piece.ROOK);
        addToChessboard(waRook, 8, 1);

        ChessPiece whRook = WhitePieceFactory.getChessPiece(Piece.ROOK);
        addToChessboard(whRook, 8, 8);

        ChessPiece baRook = BlackPieceFactory.getChessPiece(Piece.ROOK);
        addToChessboard(baRook, 1, 1);

        ChessPiece bhRook = BlackPieceFactory.getChessPiece(Piece.ROOK);
        addToChessboard(bhRook, 1,8);

    }

    public void addQueens(){
        ChessPiece wQueen = WhitePieceFactory.getChessPiece(Piece.QUEEN);
        addToChessboard(wQueen, 8, 4);

        ChessPiece bQueen = BlackPieceFactory.getChessPiece(Piece.QUEEN);
        addToChessboard(bQueen, 1, 4);
    }

    public void addKings(){
        ChessPiece wKing = WhitePieceFactory.getChessPiece(Piece.KING);
        addToChessboard(wKing, 8, 5);

        ChessPiece bKing = BlackPieceFactory.getChessPiece(Piece.KING);
        addToChessboard(bKing, 1, 5);
    }
    
}
