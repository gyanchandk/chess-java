import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Bench extends JFrame{
    //private ThirdPanel thirdPanel;

    //private TestClick testClick;
    private ChessBoard cb ;


    Bench(){
        setSize(1000,1000);

        
        cb = new ChessBoard();

        PieceLayer pl = new PieceLayer();

        JLayeredPane pane = getLayeredPane();

        JButton btn = new JButton("xx");
        btn.setBounds(10, 10, 50, 50);

        JButton btn2 = new JButton("yy");
        btn2.setBounds(20,20, 50, 50);

        pane.add(btn,2);
        pane.add(btn2,3);
        pane.add(new ChessBoard(),2);
        pane.add(new ThirdPanel(),1);
        

        //add(pl);
        //testClick = new TestClick();

        //add(testClick);

        // thirdPanel = new ThirdPanel();
        // add(thirdPanel);
        

        // PossibleSquare ps = new PossibleSquare();

        // ArrayList<Coordinate> moves = ps.getKingMoves(4,5);

        // moves = ps.getBishopMoves(2, 3);

        // moves = ps.getRookMoves(3,6);
        
        // moves = ps.getPawnMoves(7,2);

        // moves = ps.getKnightMoves(7,4);

        // thirdPanel.updateSquares(moves);

        setVisible(true);


    }

    public static void printMoves(ArrayList<Coordinate> moves){

        for(Coordinate c :moves){
            System.out.println("x:"+c.getX() +" , y:"+c.getY());
        }

    }

    public static void main(String[] args) {

        new Bench(); 

    }
    
}
