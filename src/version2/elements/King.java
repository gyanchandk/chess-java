package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;

public class King extends ChessPiece {

    protected int pieceValue = Integer.MAX_VALUE;

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        ArrayList<Cell> moves = new ArrayList<>();

        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){

            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX,nextY) ){
                ChessPiece piece =pieceTracker.getInfo(nextX, nextY);


                if(piece == null){
                    moves.add(new Cell(nextX, nextY));
                    continue;
                }

                if(piece.getTeam()!=this.getTeam()){
                    moves.add(new Cell(nextX, nextY));
                    continue;
                }

            }
        }

        return moves;
    }
    
        
}
