package version2;

public abstract class ChessPiece {
    int pieceValue;
    abstract String getName();
    abstract void drawHints(int row,int col);
}

