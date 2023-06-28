package version2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import version2.clock.ClockSetup;
import version2.layers.HintLayer;

public class HomePage extends JFrame implements ItemListener{

    private PieceTracker pieceTracker;
    private JToggleButton engineBtn;

    HomePage(){
        setSize(800,800);
        setTitle("Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLayout(new BorderLayout());

        pieceTracker = new PieceTracker();
        Font font = new Font("Arial", Font.BOLD, 40);
        JLabel label = new JLabel("engine on");
        label.setFont(new Font("Arial", Font.BOLD, 40));

        engineBtn = new JToggleButton("Engine is OFF");
        engineBtn.setFont(font);
        engineBtn.addItemListener(this);
        add(engineBtn,BorderLayout.SOUTH);
        //add(label,BorderLayout.SOUTH);

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

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(engineBtn.isSelected()){
            engineBtn.setText("Engine is ON");
            Game.setEngineOn(true);
        }else{
            Game.setEngineOn(false);
            engineBtn.setText("Engine is OFF");
        }
        
    }
    
}
