package version2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import version2.factory.Piece;
import version2.factory.WhitePieceFactory;

public class PieceLayer extends JPanel{

    PieceTracker pt = PieceTracker.getInstance();

    PieceLayer(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    public void addAllPieces(Graphics g){
        //white Pawns
        ChessPiece a2pawn = WhitePieceFactory.getChessPiece(Piece.PAWN);
        ChessPiece b2pawn = WhitePieceFactory.getChessPiece(Piece.PAWN);

        addToChessboard(a2pawn, 7, 1);
        addToChessboard(b2pawn, 7, 2);


    }

    public void addToChessboard(ChessPiece piece,int row,int col){
        pt.updatePiecePos(row, col, piece);
    }


    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        addAllPieces(g);

    }


    
}
