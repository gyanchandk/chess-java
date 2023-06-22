package version2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Knight extends ChessPiece{

    private String imagePath ="/images/whiteKnight.png";
    private int width = EnvUtility.width-5;
    private BufferedImage knightImg;
    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    Knight(){
        pieceValue = 3;

        try {
            BufferedImage img= ImageIO.read(getClass().getResource(imagePath));
            knightImg = EnvUtility.resizeImage(img, width, width);
        
        } catch (IOException e) {
    
            e.printStackTrace();
        }
    }
    @Override
    String getName() {
        return "Knight";
    }

    public void addWhiteKnights(Graphics g){
        Coordinate c = EnvUtility.coordToXY(8, 2);
        g.drawImage(knightImg, c.getX(), c.getY(), null);
        pt.updatePiecePos(8, 2, this);

        c = EnvUtility.coordToXY(8, 7);
        g.drawImage(knightImg, c.getX(), c.getY(), null);
        pt.updatePiecePos(8, 7, this);
    }
    
    public void drawHints(int row,int col){

        ArrayList<Coordinate> moves= new ArrayList<>();

        int xOffset[]={-2,-2,-1,-1,1,1,2,2};
        int yOffset[]={1,-1,2,-2,2,-2,1,-1};

        for(int i=0;i<8;i++){

            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX,nextY)){

                if(pt.getInfo(nextX, nextY)==null)
                    moves.add(new Coordinate(nextX, nextY));
            }
        }

        hl.showHints(moves);
    }
}
