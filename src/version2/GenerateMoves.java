package version2;

public class GenerateMoves implements Observer{

    private Cell selectedCell;
    private PieceTracker pieceTracker = Game.getPieceTracker();

    private void setMoves(){
        int row = selectedCell.getRow();
        int col = selectedCell.getCol();
        ChessPiece piece = pieceTracker.getInfo(row,col);
        
        Log.info(this, "set moves for :"+piece.getName()+"placed at "+selectedCell);
    }

    @Override
    public void update(Cell cell) {
        ChessPiece piece = pieceTracker.getInfo(cell.getRow(), cell.getCol());

        if(piece==null){
            //nothing to be done here
            return;
        }
        
        selectedCell= cell;
        setMoves();
    }
    
}
