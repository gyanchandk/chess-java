package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;

public class Queen extends ChessPiece{

    protected int pieceValue = 9;
    
    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovesFor'");
    }
    
    
}
