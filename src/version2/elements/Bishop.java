package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;

public class Bishop extends ChessPiece{

    protected int pieceValue = 3;

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        ArrayList<Cell> moves = new ArrayList<>();

        bishopUtil(row, col, 1, -1,moves) ;
        bishopUtil(row, col, -1, -1,moves) ;
        bishopUtil(row,col , -1, 1,moves) ;
        bishopUtil(row , col, 1, 1,moves);

        return moves;
    }

    private void bishopUtil(int x,int y,int xOffset,int yOffset, ArrayList<Cell> moves){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){

            ChessPiece piece = pieceTracker.getInfo(nextX, nextY);

            if(piece==null){
                moves.add(new Cell(nextX, nextY));
                nextX=nextX+xOffset;
                nextY=nextY+yOffset;
                continue;
            }

            if(piece.getTeam()!=this.getTeam()){
                moves.add(new Cell(nextX, nextY));
            }

            break;
            
        }

    
    }

    
}
