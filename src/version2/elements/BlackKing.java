package version2.elements;

import java.util.ArrayList;

import version2.Coordinate;
import version2.Team;

public class BlackKing extends King{
    
    private String imagePath ="/images/bk.png";
    private int pieceValue;
    private Team team;

    public BlackKing(){
        pieceValue = 5;
        team=Team.BLACK;
        loadImage(imagePath);
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String getName() {
        return "Black king";
    }

    public ArrayList<Coordinate> filterCastleMoves(ArrayList<Coordinate> moves){

        if(hasMoved)return moves;

        ArrayList<Coordinate> filteredMoves =new ArrayList<>();

        //if (8,4) is not there then (8,3) is not legal and same if(8,6) is not present (8,7) is not legal
        //for black king row=1 instead of 8

        System.out.println("Black king castling filter activated");

        int row  = 1;
        boolean fourth=isCoordinateInMoves(moves, row, 4);
        boolean sixth=isCoordinateInMoves(moves,row, 6);

        System.out.println("sixth:"+sixth+"fourth:"+fourth);

        for(Coordinate c:moves){
            if(c.getX()!=row){
                filteredMoves.add(c);
                continue;
            }

            if(c.getY()==3 && !fourth){
                continue;
            }

            if(c.getY()==7 && !sixth){
                continue;
            }

            filteredMoves.add(c);

        }

        return filteredMoves;

    }



}

