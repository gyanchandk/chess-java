import java.util.ArrayList;

public class Pawn extends ChessPiece implements ChessSquare{

    Pawn(){
        pieceValue = 1;
    }

    @Override
    public ArrayList<Coordinate> getPossibleMoves(int col, int row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPossibleMoves'");
    }

    @Override
    public String getName() {
        return "Pawn";
    }
    
}
