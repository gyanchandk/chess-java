package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;

public class Knight extends ChessPiece{

    protected int pieceValue = 3;

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovesFor'");
    }
}
