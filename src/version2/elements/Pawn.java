package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;

public class Pawn extends ChessPiece{

    protected int pieceValue = 1;

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public  ArrayList<Cell> getMovesFor(int row, int col){
        throw new UnsupportedOperationException("Unimplemented method 'getMovesFor'");
    }
    

}
