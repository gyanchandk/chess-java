package version2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import version2.factory.BlackPieceFactory;
import version2.factory.Piece;
import version2.factory.WhitePieceFactory;

public class PieceLayer extends JPanel{

    PieceTracker pt = PieceTracker.getInstance();

    private Graphics graphics;
    private boolean initializationDone=false;
    private static PieceLayer instance = new PieceLayer();

    private PieceLayer(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    public static PieceLayer getInstance(){
        return instance;
    }

    public void addAllPieces(Graphics g){
        addPawns();
        addKnights();
        addBishops();
        addRooks();
        addQueens();
        addKings();

        pt.initializeMovesStatus();

        
    }

    public void addPawns(){
        for(int col=1;col<=8;col++){
            ChessPiece wPawn = WhitePieceFactory.getChessPiece(Piece.PAWN);
            addToChessboard(wPawn,7,col);

            ChessPiece bPawn = BlackPieceFactory.getChessPiece(Piece.PAWN);
            addToChessboard(bPawn, 2, col);

        }

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

    public void addToChessboard(ChessPiece piece,int row,int col){
        pt.updatePiecePos(row, col, piece);
        piece.addImgToPieceLayer(graphics,row,col);
        
        
    }

    public void getPiecesFromPieceTracker(){
        for(int row=1;row<=8;row++){
            for(int col=1;col<=8;col++){
                ChessPiece piece = pt.getInfo(row, col);

                if(piece!=null)
                    piece.addImgToPieceLayer(graphics, row, col);
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        
        this.graphics = g;
        super.paint(g);

        if(!initializationDone)
            addAllPieces(g);
        
        initializationDone=true;

        getPiecesFromPieceTracker();


    }


    
}
