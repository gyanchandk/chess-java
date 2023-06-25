package version2;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import version2.layers.HintLayer;

public class HomePage extends JFrame{

    private PieceTracker pieceTracker;

    HomePage(){
        setSize(800,800);
        setTitle("Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLayeredPane pane = getLayeredPane();

        InteractivePanel interactivePanel = new InteractivePanel();
        interactivePanel.setBounds(100,100,500,500);
        pane.add(interactivePanel,1);

        pieceTracker = new PieceTracker();

        PieceLayer pieceLayer = new PieceLayer(pieceTracker);
        pieceLayer.setBounds(100,100,500,500);
        pane.add(pieceLayer,2);

        HightLightLayer hightLightLayer = new HightLightLayer(interactivePanel);
        hightLightLayer.setBounds(100, 100, 500, 500);
        pane.add(hightLightLayer, 3);

        HintLayer hintLayer = new HintLayer();
        hintLayer.setBounds(100, 100, 500, 500);
        pane.add(hintLayer, 3);


        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setBounds(100, 100, 500, 500);
        pane.add(chessBoard,4);

        // PlayerClock playerClock = new PlayerClock();
        // playerClock.setBounds(105, 105, 490, 40);
        // pane.add(playerClock,1);

        new Game(interactivePanel, pieceTracker, hightLightLayer, hintLayer,chessBoard);

        new SetBoard();


        setVisible(true);
    }

    
}
