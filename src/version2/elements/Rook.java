package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;

public class Rook extends ChessPiece{

    protected int pieceValue = 5;

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovesFor'");
    }

    
}
