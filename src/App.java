import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class App extends JFrame implements MouseMotionListener,MouseListener{
    int mouseX=0,mouseY=0;
    String msg="hello msg";
    Rectangle squares[]= new Rectangle[64];
    int currPosition=0;
    

    App(){
        setSize(1000, 1000);
        addMouseMotionListener(this);
        addMouseListener(this);
        setTitle("Chess");
        setLayout(new FlowLayout());
        
        

        JLayeredPane pane = getLayeredPane();
        JButton btn = new JButton("btn1");
//pane.add(btn , 2);

        TPanel tp = new TPanel();
        tp.setBounds(100, 100, 400, 400);
        pane.add(new TPanel(),1);

        

    //     ThirdPanel np = new ThirdPanel();
    //     //np.setBounds(100, 100, 400, 400);
    //    // pane.add(np,3 );

        setVisible(true);

    }

    public int getIndex(int i,int j){
        int index=(i-1)*8+(j-1);
        return index;
    }

    public void drawRectangle(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        

        int width=50;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                int xOffset=j*width;
                int yOffset = i*width;
                Rectangle r = new Rectangle(xOffset, yOffset, width, width);
                
                squares[getIndex(i, j)]=r;

                g2d.draw(r);
                if((i+j)%2!=0){
                   g2d.fill(r); 
                }
                
            }
        }

        
        
    }

    @Override
    public void paint(Graphics g) {
        
        //drawRectangle(g);
        g.drawString("mouse at "+mouseX+","+mouseY,500,500);

        
        
    }


    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               new App();
                
            }
        });
    }

   

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        currPosition = getIndex(mouseX/50, mouseY/50);

        //System.out.println(mouseX/50+","+mouseY/50);
        //repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
       // repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        currPosition = getIndex(mouseX/50, mouseY/50);

        System.out.println(mouseX/50+","+mouseY/50);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
