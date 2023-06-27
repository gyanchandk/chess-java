package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;

public class Knight extends ChessPiece{

    protected int pieceValue = 3;

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        ArrayList<Cell> moves = new ArrayList<>();

        int xOffset[]={-2,-2,-1,-1,1,1,2,2};
        int yOffset[]={1,-1,2,-2,2,-2,1,-1};

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
                }

            }
        }

        return moves;
    }
}
