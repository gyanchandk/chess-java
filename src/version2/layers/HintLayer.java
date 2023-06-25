package version2.layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import version2.Cell;
import version2.EnvUtility;

public class HintLayer  extends JPanel{

    private ArrayList<Cell> hintCells;

    private final Color focusColor = EnvUtility.getHintColor();
    private final int width = EnvUtility.width;
    private final int margin = 2;

    public HintLayer(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
    }

    private void drawHints(Graphics g,Cell highLightSquare){
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(focusColor);

        Cell cell = EnvUtility.coordToXY(highLightSquare.getRow(), highLightSquare.getCol());
        Rectangle rectangle = new Rectangle(
            cell.getRow()+margin,
            cell.getCol()+margin,
            width-2*margin,
            width-2*margin);

        g2d.fill(rectangle);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(hintCells!=null){

            for(Cell cell:hintCells){
                drawHints(g,cell);
            }
        }
    }

    public void update(ArrayList<Cell> cells){
        hintCells = cells;
    }
    
}
