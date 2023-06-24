package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.Team;

public class Queen extends ChessPiece{


    @Override
    public String getName() {
        return "Queen";
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
