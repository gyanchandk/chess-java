package version2;

public class PieceTracker {
    private ChessPiece  tracker[] = new ChessPiece[64];
    private static PieceTracker instance = new PieceTracker();

    private PieceTracker(){

    }
    public static PieceTracker getInstance(){
        return instance;

    }

    public void updatePiecePos(int row, int col, ChessPiece piece){
        int index = EnvUtility.getIndex(row, col);
        tracker[index]=piece;
    }

    public ChessPiece getInfo(int row,int col){
        int index=EnvUtility.getIndex(row, col);
        return tracker[index];
    }
}
