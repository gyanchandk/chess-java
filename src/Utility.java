import java.awt.Dimension;

public class Utility {

    public static int width =50;
    
    public static int getIndex(int row,int col){

        return (col-1)*8+row;
    }

    public static Coordinate coordToXY(int row,int col){
        Coordinate coordinate;

        coordinate = new Coordinate(col*width,row*width);

        return coordinate;
    }

    public static Dimension getPanelDimension(){
        Dimension dimension = new Dimension(width*8, width*8);

        return dimension;
    }
}
