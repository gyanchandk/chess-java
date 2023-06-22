import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Test extends JFrame{

    Test(){
        setSize(1000, 1000);
        setTitle("test ");

        JLayeredPane pane = getLayeredPane();

        JButton btn = new JButton("xx");
        btn.setBounds(10, 10, 50, 50);

        JButton btn2 = new JButton("yy");
        btn2.setBounds(20,20, 50, 50);

        //pane.add(btn,2);
        //pane.add(btn2,3);
        
        //pane.add(new ChessBoard(),2);
        pane.add(new TestClick(),1);
        pane.add(new PieceLayer(),2);
        pane.add(new ThirdPanel(),3);
        pane.add(new TPanel(),4);
        
        
    
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
    
}
