package version2;

import version2.elements.King;

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

    public void swap(int row,int col,int rookCol){

        ChessPiece rook = getInfo(row, rookCol);

        tracker[EnvUtility.getIndex(row, col)]=rook;

        tracker[EnvUtility.getIndex(row, rookCol)]=null;
        rook.setHasMoved(true);

    }

    public void  updatePiecePos(int row, int col,int newRow,int newCol){

        ChessPiece piece = getInfo(row, col);
        
        if(piece==null){
            Log.error(this, "Trying to move null piece");
        }


        int oldPosition = EnvUtility.getIndex(row, col);
        tracker[oldPosition]=null;

        int newPosition = EnvUtility.getIndex(newRow, newCol);
        tracker[newPosition]=piece;

        if(piece instanceof King && Math.abs(col-newCol)==2){
        

            if(col>newCol){
                Log.info(this, "King attempted to A-castle");

                //TODO:change this logic by calling itself with rook
                swap(row,4,1);

            }else{
                Log.info(this, "King attempted to H-castle");
                //TODO:change this logic by calling itself with rook
                swap(row,6,8);
            }
        }

        if(Game.getLeftEnpassant()){

            if(Math.abs(col-newCol)>0){

                Log.info(this, "Left en-passant attempted");
                int i = EnvUtility.getIndex(row, col-1);
                tracker[i]=null;
            }
            
        }

        if(Game.getRightEnpassant()){
            if(Math.abs(col-newCol)>0){
                Log.info(this, "Right en-passant attempted");
                int i = EnvUtility.getIndex(row, col-1);
                tracker[i]=null;
            }
        }

        Game.setRecentMoveMadeTo(new Cell(newRow, newCol));
        piece.setHasMoved(true);

        pieceLayer.repaint();

    }


    public ChessPiece getInfo(int row,int col){
        int index=EnvUtility.getIndex(row, col);
        return tracker[index];
    }

    public ChessPiece[] getTracker() {
        ChessPiece [] tmpTracker = new ChessPiece[64];

        for(int i=0;i<64;i++){
            tmpTracker[i]=tracker[i];
        }
        return tmpTracker;
    }

    
}
