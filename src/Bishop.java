import java.util.ArrayList;

public class Bishop extends ChessPiece implements ChessSquare{

    Bishop(){
        pieceValue = 3;
    }
    @Override
    public ArrayList<Coordinate> getPossibleMoves(int col, int row) {

        return null;
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    
}
