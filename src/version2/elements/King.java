package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.Team;

public class King extends ChessPiece {

    @Override
    public String getName() {
        return "King";
    }


    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }

    public boolean checkForEmptySquares(int row,int start,int end){

        for(int col=start;col<=end;col++){
            if(pt.getInfo(row, col)!=null){
                return false;
            }
        }
        
        return true;
    }
    public boolean checkForARook(int row){
        //check for a rook
        ChessPiece aRook = pt.getInfo(row, 1);

        if(aRook!=null){
            System.out.println("aRook:"+aRook.getMovedStatus());
            if(!aRook.getMovedStatus() && checkForEmptySquares(row, 2, 4)){
                return true;
            }
        }

        return false;
    }

    public boolean checkForHRook(int row){
        //check for a rook
        ChessPiece hRook = pt.getInfo(row, 8);

        if(hRook!=null){
            System.out.println("hRook:"+hRook.getMovedStatus());
            if(!hRook.getMovedStatus() && checkForEmptySquares(row, 6, 7)){
                return true;
            }
        }

        return false;
    }
    public void addHintsForCastling(int row,ArrayList<Coordinate> moves){

        if(hasMoved)return;
        //king will be in 5th col
        //row will be either 1for black king/8 for white king

        if(checkForARook(row)){
            System.out.println("******* castling allowed with a rook");
            moves.add(new Coordinate(row, 3));
        }

        if(checkForHRook(row)){
            System.out.println("******* castling allowed with h rook");
            moves.add(new Coordinate(row, 7));
        }


    }



    @Override
    public void getMoves(int row, int col, ArrayList<Coordinate> moves) {

        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){
            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX, nextY)){
                if(rules.checkForSameTeam(row, col, nextX, nextY)){
                    moves.add(new Coordinate(nextX, nextY));
                }
                
            }

            
            
        }

        if(rules.isCastlingAllowed()){
            System.out.println("CASTELING IS  ALLOWED.....!");
            addHintsForCastling(row,moves);
        }

        

    }

    public  ArrayList<Coordinate> filterCastleMoves(ArrayList<Coordinate> moves){
        throw new UnsupportedOperationException("Unimplemented method 'filterCastleMoves'");
    }

    public boolean isCoordinateInMoves(ArrayList<Coordinate> moves,int row,int col){
        
        for(Coordinate c:moves){
            if(c.isEqual(row, col))return true;
        }

        return false;
    }


        
}
