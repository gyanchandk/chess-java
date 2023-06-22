package version2;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class HomePage extends JFrame{

    HomePage(){
        setSize(800,800);
        setTitle("Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLayeredPane pane = getLayeredPane();

        InteractivePanel interactivePanel = new InteractivePanel();
        interactivePanel.setBounds(100,100,500,500);
        pane.add(interactivePanel,1);

        PieceLayer pieceLayer = new PieceLayer();
        pieceLayer.setBounds(100,100,500,500);
        pane.add(pieceLayer,2);

        HightLightLayer hightLightLayer = HightLightLayer.getInstance();
        hightLightLayer.setBounds(100, 100, 500, 500);
        pane.add(hightLightLayer, 3);

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setBounds(100, 100, 500, 500);
        pane.add(chessBoard,4);

        setVisible(true);
    }
    
}
