package version2;

import version2.factory.Piece;
import version2.factory.PieceFactory;
import version2.rules.Tester;

public class SetBoard {

    private PieceTracker pieceTracker;

    SetBoard(){
        this.pieceTracker = Game.getPieceTracker();
        addAllPieces();
        //testPosition();
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
        setPieceOnBoard(Piece.WHITE_QUEEN, 4, 6);
        setPieceOnBoard(Piece.WHITE_BISHOP, 3, 5);
        setPieceOnBoard(Piece.BLACK_ROOK, 5, 3);
        setPieceOnBoard(Piece.BLACK_KNIGHT, 6, 4);
        
    }

    private void addAllPieces(){
        addPawns();
        addKnights();
        addBishops();
        addRooks();
        addQueens();
        addKings();

    }
    public void addPawns(){
        for(int col=1;col<=8;col++){
            setPieceOnBoard(Piece.WHITE_PAWN, 7, col);
            setPieceOnBoard(Piece.BLACK_PAWN, 2, col);
        }

    }

    public void addKnights(){
        setPieceOnBoard(Piece.WHITE_KNIGHT, 8, 2);
        setPieceOnBoard(Piece.WHITE_KNIGHT, 8, 7);
        setPieceOnBoard(Piece.BLACK_KNIGHT, 1, 2);
        setPieceOnBoard(Piece.BLACK_KNIGHT, 1, 7);


    }

    public void addBishops(){
        setPieceOnBoard(Piece.WHITE_BISHOP, 8, 3);
        setPieceOnBoard(Piece.WHITE_BISHOP, 8, 6);
        setPieceOnBoard(Piece.BLACK_BISHOP, 1, 3);
        setPieceOnBoard(Piece.BLACK_BISHOP, 1, 6);
    }

    public void addRooks(){
        setPieceOnBoard(Piece.WHITE_ROOK, 8, 1);
        setPieceOnBoard(Piece.WHITE_ROOK, 8, 8);
       setPieceOnBoard(Piece.BLACK_ROOK, 1, 1);
       setPieceOnBoard(Piece.BLACK_ROOK, 1, 8);
    }

    public void addQueens(){
        setPieceOnBoard(Piece.WHITE_QUEEN, 8, 4);
        setPieceOnBoard(Piece.BLACK_QUEEN, 1, 4);
    }

    public void addKings(){
        setPieceOnBoard(Piece.WHITE_KING, 8, 5);
        setPieceOnBoard(Piece.BLACK_KING, 1, 5);
    }
    
}
