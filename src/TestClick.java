import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TestClick extends JPanel implements MouseListener{
    Rectangle squares[]= new Rectangle[64];
    Coordinate c;
    Graphics graphics;
    int width=50;

    TestClick(){
        setSize(400, 400);
        addMouseListener(this);
        setOpaque(false);
        
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
                int xOffset=i*width;
                int yOffset = j*width;
                Rectangle r = new Rectangle(xOffset, yOffset, width, width);
                
                squares[getIndex(i, j)]=r;

                g2d.draw(r);
                if((i+j)%2!=0){
                   //g2d.fill(r); 
                }
                
            }
        }

    }

    public void highlightSquare(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        int index = getIndex(c.getX(), c.getY());

        if(index>=64)return;

        Rectangle r = squares[index];

        g2d.fillRect(r.x+5,r.y+5,40,40);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //drawRectangle(g);

        if(c!=null){
            highlightSquare(g);
        }

    }

    public void updateSquare(Coordinate coordinate){

        c = coordinate;
        repaint();
    }

    public Coordinate getRowCol(int x,int y){
        Coordinate coordinate = new Coordinate(x/width, y/width);

        return coordinate;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

        Coordinate c = getRowCol(e.getX(), e.getY());
        
        System.out.println(c.getX()+","+c.getY());
        //updateSquare(c);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
    
}
