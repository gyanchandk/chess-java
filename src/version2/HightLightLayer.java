package version2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class HightLightLayer extends JPanel implements Observer{

    private Cell highLightSquare;
    private final Color focusColor = EnvUtility.getHighLightColor();
    private final int width = EnvUtility.width;
    private final int margin = 2;

    HightLightLayer(InteractivePanel interactivePanel){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        interactivePanel.attach(this);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        if(highLightSquare==null)return;

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
    public void update(Cell cell) {
        highLightSquare = cell;
        repaint();
    }
}
