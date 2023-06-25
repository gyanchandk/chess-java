package version2;

public class PieceTracker {
    private PieceLayer pieceLayer;

    private ChessPiece  tracker[] = new ChessPiece[64];

    public void attach(PieceLayer pieceLayer){
        this.pieceLayer = pieceLayer;
    }

    public void setInitialPosition(ChessPiece piece, int row,int col){
        int position = EnvUtility.getIndex(row, col);
        tracker[position]=piece;

        pieceLayer.repaint();
    }

    public void  updatePiecePos(int row, int col,int newRow,int newCol,ChessPiece piece){
        if(piece==null){
            Log.error(this, "Trying to move null piece");
        }

        int oldPosition = EnvUtility.getIndex(row, col);
        tracker[oldPosition]=null;

        int newPosition = EnvUtility.getIndex(newRow, newCol);
        tracker[newPosition]=piece;

        piece.setHasMoved(true);

        pieceLayer.repaint();

    }


    public ChessPiece getInfo(int row,int col){
        int index=EnvUtility.getIndex(row, col);
        return tracker[index];
    }

    public ChessPiece[] getTracker() {
        return tracker;
    }

    
}
