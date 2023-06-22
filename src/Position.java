public class Position {
    public static int width=50;

    public static int kx=width*7+5,ky=width*8+5;
    

    public static Coordinate whiteRookLeft(){
        int y = width*8+5;
        int x = width+5;

        return new Coordinate(x, y);
    }

    public static Coordinate whiteRookRight(){
        int y = width*8+5;
        int x = width*8+5;

        return new Coordinate(x, y);
    }

    public static Coordinate whiteKnightLeft(){
        int y = width*8+5;
        int x = width*2+5;

        return new Coordinate(x, y);
    }
    public static Coordinate whiteKnightRight(){
       

        return new Coordinate(kx,ky);
    }
    public static Coordinate whiteBishopLeft(){
       
        int y = width*8+5;
        int x = width*3+5;

        return new Coordinate(x, y);
    }

    public static Coordinate whiteBishopRight(){
        int y = width*8+5;
        int x = width*6+5;

        return new Coordinate(x, y);
    }
}
