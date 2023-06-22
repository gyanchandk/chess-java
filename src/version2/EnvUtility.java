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

    public static Coordinate coordToXY(int row,int col){
        Coordinate coordinate;

        coordinate = new Coordinate(col*width,row*width);

        return coordinate;
    }

    public static Dimension getPanelDimension(){
        Dimension dimension = new Dimension(width*8+50, width*8+50);

        return dimension;
    }

    public static Color getBoardColor(){
        return new Color(15,99,15);
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    public static boolean check(int x, int y){

        if(x<1 || x>8 || y<1 || y>8){
            return false;
        }

        return true;
    }
}
