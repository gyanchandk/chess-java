import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ThirdPanel extends JPanel{
    Rectangle squares[]= new Rectangle[64];
    int currPosition=0;
    ArrayList<Coordinate> moves = new ArrayList<>();

    boolean highlight=false;

    ThirdPanel(){
        setSize(600, 600);
        setOpaque(false);
    }
    public int getIndex(int i,int j){
        int index=(i-1)*8+(j-1);
        return index;
    }


    public void drawRectangle(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        
        g2d.setColor(Color.ORANGE);

        int width=50;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                int xOffset=j*width;
                int yOffset = i*width;
                Rectangle r = new Rectangle(xOffset, yOffset, width, width);
                
                squares[getIndex(i, j)]=r;

                //g2d.draw(r);
                g2d.fillRect(r.x+10, r.y+10, 30, 30);
                if((i+j)%2!=0){
                   
                }
                
            }
        }
        g2d.setColor(Color.ORANGE);
        //g2d.fill(squares[10]);

       
        
        
    }

    public void highlightSquares(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLUE);

        for(Coordinate c:moves){
            int index = getIndex(c.getX(), c.getY());
            Rectangle r = squares[index];

            //g2d.fillRect(r.x, r.y, 50, 50);

            //g2d.setColor(Color.white);
            g2d.fillRect(r.x+5, r.y+5, 40, 40);
        }
        
    }

    @Override
    public void paint(Graphics g) {
        
        //if(!highlight)
            drawRectangle(g);

        //if(highlight){
            highlightSquares(g);
        //}
        
    }

    public void updateSquares(ArrayList<Coordinate> hightLightedMoves){
        moves.clear();

        moves=hightLightedMoves;
        highlight = true;
        repaint();

    }


    
}
