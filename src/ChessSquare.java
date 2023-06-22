import java.util.ArrayList;

public interface ChessSquare {
    ArrayList<Coordinate> getPossibleMoves(int col,int row);
    
}
