package version2;

import java.util.ArrayList;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        String str = "("+x+","+y+")";
        return str;
    }

    public boolean isEqual(int row,int col){
        return (getX()==row && getY()==col);
    }

    public static void printMoves(ArrayList<Coordinate> moves){
        for(Coordinate c:moves){
            System.out.println(c);
        }
    }
}
