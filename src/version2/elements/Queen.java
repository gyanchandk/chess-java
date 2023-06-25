package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;
import version2.Log;

public class Queen extends ChessPiece{

    protected int pieceValue = 9;
    
    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {

        ArrayList<Cell>  moves = new ArrayList<>();

        moves.addAll(getBishopMoves(row, col));
        moves.addAll(getRookMoves(row, col));

        return moves;
        
    
    }

    public ArrayList<Cell> getRookMoves(int row, int col) {

        ArrayList<Cell> moves = new ArrayList<>();

        rookUtil(row, col, 0, -1,moves);
        rookUtil(row, col, 0, 1,moves) ;
        rookUtil(row,col , -1, 0,moves) ;
        rookUtil(row , col, 1, 0,moves);

        return moves;
    }

    private void rookUtil(int x,int y,int xOffset,int yOffset,ArrayList<Cell> moves){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){

            Log.error(this,  nextX+","+nextY);

            ChessPiece piece = pieceTracker.getInfo(nextX, nextY);

            if(piece==null){

                moves.add(new Cell(nextX, nextY));

                nextX+=xOffset;
                nextY+=yOffset;
                continue;
            }

            if(piece.getTeam()!=this.getTeam()){
                moves.add(new Cell(nextX, nextY));
            }

            break;

        }
    
    }

    public ArrayList<Cell> getBishopMoves(int row, int col) {
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
