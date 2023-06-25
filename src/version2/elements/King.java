package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;

public class King extends ChessPiece {

    protected int pieceValue = Integer.MAX_VALUE;

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovesFor'");
    }
    
        
}
