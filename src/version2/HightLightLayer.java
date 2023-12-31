package version2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class HightLightLayer extends JPanel implements Observer{

    private Cell highLightSquare;
    private Cell destSquare;
    private final Color focusColorForLightSquare =EnvUtility.getHighLightColorForLightSquare();
    private final Color focusColorForDarkSquare =EnvUtility.getHighLightColorForDarkSquare();
    private final int width = EnvUtility.width;
    private final int margin = 2;
    private PieceTracker pieceTracker;
    

    public HightLightLayer(InteractivePanel interactivePanel,PieceTracker pieceTracker){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        interactivePanel.attach(this);

        this.pieceTracker =pieceTracker;
    }

    public void colorCell(Cell hCell,Color color,Graphics g){

        Graphics2D g2d = (Graphics2D)g;

        Cell cell = EnvUtility.coordToXY(hCell.getRow(), hCell.getCol());
        Rectangle rectangle = new Rectangle(
            cell.getRow()+margin,
            cell.getCol()+margin,
            width-2*margin,
            width-2*margin);

        if((hCell.getRow()+hCell.getCol())%2==0){
            g2d.setColor(focusColorForLightSquare);
        }else{
            g2d.setColor(focusColorForDarkSquare);
        }

        g2d.fill(rectangle);



    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        

        if(destSquare!=null){
            colorCell(destSquare, focusColorForDarkSquare, g);
        }

        if(highLightSquare!=null){
            colorCell(highLightSquare, focusColorForDarkSquare, g);
        }


        
    }


    @Override
    public void update(Cell cell) {

        ChessPiece piece = pieceTracker.getInfo(cell.getRow(), cell.getCol());
        if(piece==null){
            return;
        }

        if(piece.getTeam()!=Game.getTurn()){
            return;
        }

        highLightSquare = cell;
        repaint();
    }

    public void updateDestinationSquare(Cell cell){
        destSquare = cell;
        repaint();
    }
}
