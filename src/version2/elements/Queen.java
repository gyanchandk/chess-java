package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class Queen extends ChessPiece{

    

    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public void drawHints(int row, int col) {
        ArrayList<Coordinate> moves= new ArrayList<>();

        getMoves(row, col, moves);

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);
    }

    
    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }

    @Override
    public void getMoves(int row, int col, ArrayList<Coordinate> moves) {
        Bishop bishop = new Bishop();
        bishop.getMoves(row, col, moves);

        Rook rook = new Rook();
        rook.getMoves(row, col, moves);
    }
    
}
