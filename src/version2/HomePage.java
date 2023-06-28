package version2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

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



        new Game(interactivePanel, pieceTracker, hightLightLayer, hintLayer,chessBoard);

        new SetBoard();
        setVisible(true);
    }

    public void alternateWay(){
        JLayeredPane pane = getLayeredPane();

        JLabel label = new JLabel("\u2654");
        label.setBounds(10, 10, 50, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 35));
        pane.add(label,1);

        InteractivePanel interactivePanel = new InteractivePanel();
        interactivePanel.setBounds(100,100,500,500);
        pane.add(interactivePanel,1);

        ClockSetup clockSetup = new ClockSetup();
        clockSetup.setBounds(100,100,500,500);
        pane.add(clockSetup,1);


        pieceTracker = new PieceTracker();

        PieceLayer pieceLayer = new PieceLayer(pieceTracker);
        pieceLayer.setBounds(100,100,500,500);
        pane.add(pieceLayer,2);

        HightLightLayer hightLightLayer = new HightLightLayer(interactivePanel,pieceTracker);
        hightLightLayer.setBounds(100, 100, 500, 500);
        pane.add(hightLightLayer, 3);

        HintLayer hintLayer = new HintLayer(interactivePanel,pieceTracker);
        hintLayer.setBounds(100, 100, 500, 500);
        pane.add(hintLayer, 3);


        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setBounds(100, 100, 500, 500);
        pane.add(chessBoard,4);

        // PlayerClock playerClock = new PlayerClock();
        // playerClock.setBounds(105, 105, 490, 40);
        // pane.add(playerClock,1);

        new Game(interactivePanel, pieceTracker, hightLightLayer, hintLayer,chessBoard);



    }

    
}
