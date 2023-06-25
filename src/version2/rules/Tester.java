package version2.rules;

import version2.Cell;
import version2.ChessPiece;
import version2.Game;
import version2.PieceTracker;
import version2.Team;
import version2.layers.HintLayer;

public class Tester {
    private static PieceTracker pieceTracker=Game.getPieceTracker();
    private static HintLayer hintLayer = Game.getHintLayer();

    public static void  check(){
        
        new KingCheck().isKingInCheck(pieceTracker.getTracker(),Team.BLACK);
        new KingCheck().isKingInCheck(pieceTracker.getTracker(),Team.WHITE);
    }

    public static void checkFor(int row, int col){
        ChessPiece piece = pieceTracker.getInfo(row, col);

        if(piece==null)return;

        Cell.printMoves(piece.getMovesFor(row, col));

        hintLayer.update(piece.getMovesFor(row, col));
        hintLayer.repaint();

        
    }


    
    
}
