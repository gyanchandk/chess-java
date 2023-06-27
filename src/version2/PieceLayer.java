package version2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import version2.elements.PieceImageFactory;

public class PieceLayer extends JPanel{

    private PieceTracker pieceTracker;
    private final int width = EnvUtility.width;

    PieceLayer(PieceTracker pieceTracker){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));

        this.pieceTracker = pieceTracker;
        pieceTracker.attach(this);
    }

    
    public void getPiecesFromPieceTracker(Graphics graphics){
        for(int row=1;row<=8;row++){
            for(int col=1;col<=8;col++){
                ChessPiece piece = pieceTracker.getInfo(row, col);

                if(piece!=null)
                    addImgToPieceLayer(graphics,piece, row, col);
            }
        }
    }

    public void addImgToPieceLayer(Graphics g, ChessPiece piece,int row,int col){
        Cell cell=EnvUtility.coordToXY(row,col);

        String imagePath =PieceImageFactory.getImagepath(piece.pieceType);
        BufferedImage image = getImage(imagePath);
        g.drawImage(image,cell.getRow(),cell.getCol(),null);
        
    }


    @Override
    public void paint(Graphics g) {
        //Log.info(this, "Paint method is called");

        super.paint(g);

        getPiecesFromPieceTracker(g);

    }

    private BufferedImage getImage(String imagePath){
        BufferedImage pieceImg=null;
        try {
            BufferedImage img= ImageIO.read(getClass().getResource(imagePath));
            pieceImg = EnvUtility.resizeImage(img, width, width);
        
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pieceImg;
    }


    
}
