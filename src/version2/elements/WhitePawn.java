package version2.elements;


import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class WhitePawn extends ChessPiece{
    private String imagePath ="/images/wp.png";
    private HightLightLayer hl = HightLightLayer.getInstance();
    PieceTracker pt = PieceTracker.getInstance();
    private int pieceValue;
    private Team team;

    public WhitePawn(){
        pieceValue = 1;
        team = Team.WHITE;
        super.loadImage(imagePath);
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String getName() {
        return "White Pawn";
    }

    @Override
    public void drawHints(int row, int col) {
        ArrayList<Coordinate> moves= new ArrayList<>();

        if(EnvUtility.check(row-1, col))
            moves.add(new Coordinate(row-1, col));
        
        if(EnvUtility.check(row-2, col))
            moves.add(new Coordinate(row-2, col));
        
        if(EnvUtility.check(row-1, col-1))
            moves.add(new Coordinate(row-1, col-1));
        
        if(EnvUtility.check(row-1, col+1))
            moves.add(new Coordinate(row-1, col+1));

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);
    }
    
}
