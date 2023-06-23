package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class Bishop extends ChessPiece{
    

    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public void drawHints(int row, int col) {
        ArrayList<Coordinate> moves= new ArrayList<>();

        getMoves(row, col, moves);

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);

    }

    public void getMoves(int row,int col,ArrayList<Coordinate> moves){
        bishopUtil(row, col, 1, -1,moves);
        bishopUtil(row, col, -1, -1,moves);
        bishopUtil(row,col , -1, 1,moves);
        bishopUtil(row , col, 1, 1,moves);
    }

    private void bishopUtil(int x,int y,int xOffset,int yOffset,ArrayList<Coordinate> moves){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){

            if(rules.checkForSameTeam(x, y, nextX, nextY)){
                moves.add(new Coordinate(nextX, nextY));
            }
            else{
                break;
            }

            if(pt.getInfo(nextX, nextY)!=null){
                break;
            }
            
            nextX=nextX+xOffset;
            nextY=nextY+yOffset;
        }
    }

    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }
    
}
