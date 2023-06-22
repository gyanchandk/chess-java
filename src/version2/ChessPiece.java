package version2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ChessPiece {
    abstract public String getName();
    abstract public void drawHints(int row,int col);
    abstract public Team getTeam();

    protected BufferedImage pieceImg;
    protected int width = EnvUtility.width;
    protected ChessRules rules = ChessRules.getInstance();

    public void loadImage(String imagePath){
        try {
            BufferedImage img= ImageIO.read(getClass().getResource(imagePath));
            pieceImg = EnvUtility.resizeImage(img, width, width);
        
        } catch (IOException e) {
    
            e.printStackTrace();
        }
    }

    public void addImgToPieceLayer(Graphics g, int row,int col){

        Coordinate c;
        c = EnvUtility.coordToXY(row,col);
        g.drawImage(pieceImg, c.getX(), c.getY(), null);
        
    }
}

