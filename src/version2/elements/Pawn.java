package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.Team;

public class Pawn extends ChessPiece{

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }

    @Override
    public void getMoves(int row, int col, ArrayList<Coordinate> moves) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoves'");
    }

    @Override
    public ArrayList<Coordinate> filterCastleMoves(ArrayList<Coordinate> moves) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterCastleMoves'");
    }
    
}
