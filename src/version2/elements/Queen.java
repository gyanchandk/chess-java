package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;

public class Queen extends ChessPiece{

    ArrayList<Coordinate> moves= new ArrayList<>();

    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public void drawHints(int row, int col) {
        moves.clear();
        bishopUtil(row, col, 1, -1);
        bishopUtil(row, col, -1, -1);
        bishopUtil(row,col , -1, 1);
        bishopUtil(row , col, 1, 1);

        for(int nextX=row-7; nextX<=8;nextX++){
            if(EnvUtility.check(nextX, col)){
                moves.add(new Coordinate(nextX,col));
            }
        }

        for(int nextY=col-7;nextY<=8;nextY++){
            if(EnvUtility.check(row, nextY)){
                moves.add(new Coordinate(row, nextY));
            }
        }

        hl.showHints(moves);
    }


    private void bishopUtil(int x,int y,int xOffset,int yOffset){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){
            moves.add(new Coordinate(nextX, nextY));
            nextX=nextX+xOffset;
            nextY=nextY+yOffset;
        }
    }
    
}
