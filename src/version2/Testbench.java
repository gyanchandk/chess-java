package version2;

import java.util.ArrayList;

public class Testbench {
    public static void main(String[] args) {
        
        ArrayList<Coordinate> moves = new ArrayList<>();

        moves.add(new Coordinate(2, 3));
        moves.add(new Coordinate(4,5));

        for(Coordinate c:moves){

            if(c.getX()==2){
                moves.remove(c);
            }
            
        }

        for(Coordinate c:moves){

           System.out.println(c);
            
        }

        System.out.println(moves.size());

    
    }
}
