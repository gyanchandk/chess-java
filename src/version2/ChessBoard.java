package version2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ChessBoard extends JPanel {
    
    ChessBoard(){
        setSize(EnvUtility.getPanelDimension());
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public void drawRectangles(Graphics g){

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(EnvUtility.getBoardColor());
    
        for(int row=1;row<=8;row++){
            for(int col=1;col<=8;col++){
                Cell cell = EnvUtility.coordToXY(row, col);

                Rectangle rectangle = new Rectangle(
                        cell.getRow(), cell.getCol(), EnvUtility.width, EnvUtility.width);

                g2d.draw(rectangle);

                if((row+col)%2!=0){
                    g2d.fill(rectangle);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);

    }
}
