package version2;

import version2.layers.HintLayer;

public class Game {
    private static InteractivePanel interactivePanel;
    private static PieceTracker pieceTracker;
    private static HightLightLayer hightLightLayer;
    private static ChessBoard chessBoard;
    private static HintLayer hintLayer;


    public Game(InteractivePanel interactivePanel,
        PieceTracker pieceTracker,
        HightLightLayer hightLightLayer,
        HintLayer hintLayer,
        ChessBoard chessBoard){

            Game.interactivePanel = interactivePanel;
            Game.pieceTracker = pieceTracker;
            Game.hightLightLayer = hightLightLayer;
            Game.hintLayer = hintLayer;
            Game.chessBoard = chessBoard;

    }

    public static ChessBoard getChessBoard() {
        return chessBoard;
    }

    public static InteractivePanel getInteractivePanel() {
        return interactivePanel;
    }
    
    public static PieceTracker getPieceTracker() {
        return pieceTracker;
    }

    public static HightLightLayer getHightLightLayer() {
        return hightLightLayer;
    }

    public static HintLayer getHintLayer() {
        return hintLayer;
    }
}
