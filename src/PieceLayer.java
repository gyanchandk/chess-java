import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class PieceLayer extends JPanel{

    int width=50;
    Rectangle squares[]= new Rectangle[64];

    PieceLayer(){
        setSize(600, 600);
        setOpaque(false);

    }
    public int getIndex(int i,int j){
        int index=(i-1)*8+(j-1);
        return index;
    }
    
    public void drawRectangle(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        

        g2d.setColor(Color.green);

        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                int xOffset=i*width;
                int yOffset = j*width;
                Rectangle r = new Rectangle(xOffset, yOffset, width, width);
                
                squares[getIndex(i, j)]=r;

                //g2d.draw(r);
                
                g2d.fillRect(r.x+20, r.y+20, 10, 10);
                
            }
        }

    }


    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        drawRectangle(g);

    }
    
}
