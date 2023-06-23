package version2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HightLightLayer extends JPanel{
    private Coordinate hc;
    private  boolean showHints=false;
    private ArrayList<Coordinate> hintSquares;
    private Coordinate kCoordinate;

    private ChessPiece currPiece;

    private static HightLightLayer instance = new HightLightLayer();
    
    private HightLightLayer(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
    }

    public static HightLightLayer getInstance(){
        return instance;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;

        if(showHints){
            makeHints(g);
            showHints=false;
        }

        if(hc!=null){
            Coordinate c = EnvUtility.coordToXY(hc.getX(), hc.getY());
            Rectangle rectangle = new Rectangle(
                c.getX(), c.getY(), EnvUtility.width, EnvUtility.width);
            
            g2d.setColor(new Color(213,230,92));

            if((hc.getX()+hc.getY())%2!=0)
                g2d.setColor(new Color(26,181,42));

            g2d.fill(rectangle);

        }

        if(kCoordinate!=null){
            Coordinate c = EnvUtility.coordToXY(kCoordinate.getX(), kCoordinate.getY());
            Rectangle rectangle = new Rectangle(
                c.getX(), c.getY(), EnvUtility.width, EnvUtility.width);
            
            g2d.setColor(Color.red);
            g2d.fill(rectangle);

        }




    }

    public void setHighlightSquare(int row,int col){
        hc = new Coordinate(row, col);
        repaint();
    }

    public void highlightKingSquareWhenChecked(Coordinate coordinate){
        kCoordinate=coordinate;

        System.out.println("called for"+kCoordinate+ "to highlight");
        repaint();

    }

    public void showHints(ArrayList<Coordinate> hintCoord){
        hintSquares = hintCoord;
        showHints=true;
        repaint();
    }

    public void makeHints(Graphics g){

        Graphics2D g2d = (Graphics2D)g;
        g.setColor(EnvUtility.getHintColor());

        if(!showHints)return;
        Coordinate canvasPos;
        for(Coordinate c:hintSquares){
            canvasPos = EnvUtility.coordToXY(c.getX(), c.getY());
            
            Rectangle rect = new Rectangle(
                canvasPos.getX(), canvasPos.getY(), EnvUtility.width, EnvUtility.width);
            g2d.fill(rect);
            
            if((c.getX()+c.getY())%2==0){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(EnvUtility.getBoardColor());
            }
            

            Rectangle rect2 = new Rectangle(
                canvasPos.getX()+5, canvasPos.getY()+5, EnvUtility.width-10, EnvUtility.width-10);
            g2d.fill(rect2);

            g.setColor(EnvUtility.getHintColor());

            
        }


    }
}
