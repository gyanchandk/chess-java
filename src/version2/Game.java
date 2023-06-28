package version2;

import version2.chessEngine.SimpleEngine;
import version2.layers.HintLayer;

public class Game {
    private static InteractivePanel interactivePanel;
    private static PieceTracker pieceTracker;
    private static HightLightLayer hightLightLayer;
    private static ChessBoard chessBoard;
    private static HintLayer hintLayer;
    private static Cell recentMoveMadeTo=null;
    private static boolean leftEnpassant=false;
    private static boolean rightEnPassant = false;
    private static GameStatus gameStatus = GameStatus.ONGOING;

    private static Team turn = Team.WHITE;
    private static SimpleEngine simpleEngine;


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

            simpleEngine = new SimpleEngine(hintLayer, pieceTracker);

    }

    public static void changeTurn(){
        if(turn == Team.WHITE){
            turn = Team.BLACK;

            Log.info(Game.class, "ready to make engine move");
            simpleEngine.makeMove();
        }else{
            turn = Team.WHITE;
        }

        System.out.println( "**************** Turn for :"+turn+"*********");
        Game.leftEnpassant=false;
        Game.rightEnPassant=false;
    }

    public static void setRecentMoveMadeTo(Cell recentMoveMadeTo) {
        Game.recentMoveMadeTo = recentMoveMadeTo;
        hightLightLayer.updateDestinationSquare(recentMoveMadeTo);
    }

    public static Cell getRecentMoveMadeTo() {
        return recentMoveMadeTo;
    }

    public static Team getTurn(){
        return turn;
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

    public static void setLeftEnpassant(boolean leftEnpassant) {
        Game.leftEnpassant = leftEnpassant;
    }

    public static void setRightEnPassant(boolean rightEnPassant) {
        Game.rightEnPassant = rightEnPassant;
    }

    public static boolean getLeftEnpassant() {
        return leftEnpassant;
    }

    public static boolean getRightEnpassant() {
        return rightEnPassant;
    }

    public static void setGameStatus(GameStatus gameStatus) {
        Game.gameStatus = gameStatus;
    }

    public static GameStatus getGameStatus() {
        return gameStatus;
    }
}
