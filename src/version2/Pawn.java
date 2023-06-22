package version2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Pawn extends ChessPiece{

    private String imagePath ="/images/wp.png";
    private int width = EnvUtility.width-5;
    private BufferedImage whitePawnImg;
    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();


    Pawn(){
        pieceValue = 1;
        try {
            BufferedImage img= ImageIO.read(getClass().getResource(imagePath));
            whitePawnImg = EnvUtility.resizeImage(img, width, width);
        
        } catch (IOException e) {
    
            e.printStackTrace();
        }
    }
    @Override
    String getName() {
        return "Pawn";
    }

    public void addWhitePawns(Graphics g){
        Coordinate c;
        for(int row=7,col=1;col<=8;col++){
            c = EnvUtility.coordToXY(row,col);

            pt.updatePiecePos(row, col, this);
            g.drawImage(whitePawnImg, c.getX(), c.getY(), null);
        }
        
    }

    public void drawHints(int row,int col){
        ArrayList<Coordinate> moves= new ArrayList<>();

        if(EnvUtility.check(row-1, col))
            moves.add(new Coordinate(row-1, col));
        
        if(EnvUtility.check(row-2, col))
            moves.add(new Coordinate(row-2, col));
        
        if(EnvUtility.check(row-1, col-1))
            moves.add(new Coordinate(row-1, col-1));
        
        if(EnvUtility.check(row-1, col+1))
            moves.add(new Coordinate(row-1, col+1));

        hl.showHints(moves);
    }
    
}
