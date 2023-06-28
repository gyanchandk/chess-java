package version2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import version2.clock.ClockSetup;
import version2.layers.HintLayer;

public class HomePage extends JFrame{

    private PieceTracker pieceTracker;

    HomePage(){
        setSize(800,800);
        setTitle("Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLayout(new BorderLayout());

        pieceTracker = new PieceTracker();

        GameOverLayer gameOverLayer = new GameOverLayer();
        add(gameOverLayer,BorderLayout.CENTER);

        ClockSetup clockSetup = new ClockSetup();
        add(clockSetup,BorderLayout.CENTER);

        InteractivePanel interactivePanel = new InteractivePanel();
        add(interactivePanel,BorderLayout.CENTER);

        PieceLayer pieceLayer = new PieceLayer(pieceTracker);
        add(pieceLayer,BorderLayout.CENTER);

        HightLightLayer hightLightLayer= new HightLightLayer(interactivePanel, pieceTracker);
        add(hightLightLayer,BorderLayout.CENTER);

        HintLayer hintLayer = new HintLayer(interactivePanel, pieceTracker);
        add(hintLayer,BorderLayout.CENTER);

        ChessBoard chessBoard = new ChessBoard();
        add(chessBoard,BorderLayout.CENTER);



        new Game(interactivePanel, 
        pieceTracker, 
        hightLightLayer, 
        hintLayer,
        chessBoard,
        gameOverLayer);

        new SetBoard();
        setVisible(true);
    }

   
    
}
