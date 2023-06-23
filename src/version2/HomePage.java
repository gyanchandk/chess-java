package version2;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import version2.player.PlayerClock;

public class HomePage extends JFrame{

    HomePage(){
        setSize(800,800);
        setTitle("Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLayeredPane pane = getLayeredPane();

        InteractivePanel interactivePanel = new InteractivePanel();
        interactivePanel.setBounds(100,100,500,500);
        pane.add(interactivePanel,1);

        PieceLayer pieceLayer = PieceLayer.getInstance();
        pieceLayer.setBounds(100,100,500,500);
        pane.add(pieceLayer,2);

        HightLightLayer hightLightLayer = HightLightLayer.getInstance();
        hightLightLayer.setBounds(100, 100, 500, 500);
        pane.add(hightLightLayer, 3);

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setBounds(100, 100, 500, 500);
        pane.add(chessBoard,4);

        PlayerClock playerClock = new PlayerClock();
        playerClock.setBounds(105, 105, 490, 40);
        pane.add(playerClock,1);


        setVisible(true);
    }
    
}
