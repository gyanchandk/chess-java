package version2;

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
}
