package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;

public class King extends ChessPiece {

    ArrayList<Coordinate> moves= new ArrayList<>();

    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public void drawHints(int row, int col) {
        moves.clear();
        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){
            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX, nextY)){
                moves.add(new Coordinate(nextX, nextY));
            }
            
        }

        hl.showHints(moves);
    }
        
}
