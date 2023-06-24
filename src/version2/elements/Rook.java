package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.Team;

public class Rook extends ChessPiece{

    @Override
    public String getName() {
        return "Rook";
    }


    public void getMoves(int row,int col, ArrayList<Coordinate> moves){
        //to-left
        for(int nextY=col-1;nextY>=1;nextY--){
            if(EnvUtility.check(row, nextY)){

                if(rules.checkForSameTeam(row, col, row, nextY)){
                    moves.add(new Coordinate(row, nextY));
                }
                else{
                    break;
                }

                if(pt.getInfo(row, nextY)!=null){
                    break;
                }
            }
        }
        
        //to-right
        for(int nextY=col+1;nextY<=8;nextY++){
            if(EnvUtility.check(row, nextY)){

                if(rules.checkForSameTeam(row, col, row, nextY)){
                    moves.add(new Coordinate(row, nextY));
                }
                else{
                    break;
                }

                if(pt.getInfo(row, nextY)!=null){
                    break;
                }

                
                
            }
        }
        //to-down
        for(int nextX=row+1; nextX<=8;nextX++){
            if(EnvUtility.check(nextX, col)){

                if(rules.checkForSameTeam(row, col, nextX, col)){
                    moves.add(new Coordinate(nextX,col));
                }
                else{
                    break;
                }

                if(pt.getInfo(nextX, col)!=null){
                    break;
                }
            }
        }
        
        //to-up
        for(int nextX=row-1; nextX>=1;nextX--){
            if(EnvUtility.check(nextX, col)){

                if(rules.checkForSameTeam(row, col, nextX, col)){
                    moves.add(new Coordinate(nextX,col));
                }
                else{
                    break;
                }

                if(pt.getInfo(nextX, col)!=null){
                    break;
                }
            }
        }


    }

    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }


    @Override
    public ArrayList<Coordinate> filterCastleMoves(ArrayList<Coordinate> moves) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterCastleMoves'");
    }
    
}
