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
        Dimension dimension = new Dimension(width*8+50, width*8+50);

        return dimension;
    }

    public static Color getBoardColor(){
        Color darkGreenish = new Color(24,120,105);
        // Color purple = new Color(85,24,120);
        // Color lightGray = new Color(84,84,77);

        // Color colors[]={darkGreenish,purple,lightGray};

        // Random random = new Random();
        // int index = random.nextInt(3);

        return darkGreenish;
    }

    public static Color getHintColor(){
        Color hintColor = new Color(207, 51, 27);

        return hintColor;
    }

    public static Color getHighLightColor(){
        Color hColor = Color.YELLOW;

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
