package version2.rules;

import version2.Game;
import version2.PieceTracker;
import version2.Team;

public class Tester {
    private static PieceTracker pieceTracker=Game.getPieceTracker();

    public static void  check(){
        
        new KingCheck().isKingInCheck(pieceTracker.getTracker(),Team.BLACK);
        new KingCheck().isKingInCheck(pieceTracker.getTracker(),Team.WHITE);

    }



    
    
}
