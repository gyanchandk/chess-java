package version2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EnvUtility {
    public static int width =50;
    
    public static int getIndex(int row,int col){

        return (col-1)*8+row-1;
    }

    public static Coordinate indexToRowCol(int index){
        
        int row =index/8;
        int col = index-(row*8)+1;
        return  new Coordinate(row+1, col);
    }

    public static Cell coordToXY(int row,int col){
        return new Cell(col*width,row*width);
    }

    public static Dimension getPanelDimension(){
        Dimension dimension = new Dimension(width*8+100, width*8+100);

        return dimension;
    }

    public static Color getBoardColor(){
        Color darkGreenish = new Color(0,102,0);
     
        return darkGreenish;
    }

    public static Color getHintColor(){
        Color hintColor = new Color(255, 163, 26);

        return hintColor;
    }

    public static Color getHighLightColorForLightSquare(){
        Color hColor = new Color(255, 255, 128);

        return hColor;
    }
    public static Color getHighLightColorForDarkSquare(){
        Color hColor = new Color(0, 230, 0);

        return hColor;
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    public static boolean check(int row, int col){

        if(row>=1 && row<=8 && col>=1 && col<=8)
            return true;

        return false;
    }
}
