package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class Knight extends ChessPiece{
    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    @Override
    public String getName() {
        return "Knight";
    }
    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void drawHints(int row, int col) {
        ArrayList<Coordinate> moves= new ArrayList<>();

        Team team = pt.getInfo(row, col).getTeam();

        int xOffset[]={-2,-2,-1,-1,1,1,2,2};
        int yOffset[]={1,-1,2,-2,2,-2,1,-1};

        for(int i=0;i<8;i++){

            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX,nextY) ){
                
                if(rules.checkForSameTeam(row, col, nextX, nextY)){
                    moves.add(new Coordinate(nextX, nextY));
                }

            }
        }

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);
    }
    
}
