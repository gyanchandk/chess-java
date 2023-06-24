package version2;

import java.util.ArrayList;

//when player does not has a legal move to make;
//it means if hints of all pieces are empty

public class Stalemate {
    private PieceTracker pt = PieceTracker.getInstance();

    public boolean checkForStalemate(Team turn){

        System.out.println("Moves Available for "+turn);
        ArrayList<Coordinate> moves;

        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){

                ChessPiece piece = pt.getInfo(i, j);

                if(piece==null)continue;

                if(piece.getTeam()!=turn)continue;

                

                //if(moves.size()>0)return false;
            }
            
        }


        return true;
    }

    public void printMoves(ArrayList<Coordinate> moves){
        for(Coordinate c:moves){
            System.out.println(c);
        }
    }

}