package version2.rules;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;
import version2.Game;
import version2.Log;
import version2.PieceTracker;
import version2.Team;

public class LegalMove {
    
    private ChessPiece[] board = new ChessPiece[64];
    private PieceTracker pieceTracker = Game.getPieceTracker();

    public ChessPiece getPiece(int row,int col){

        int index=EnvUtility.getIndex(row, col);
        return board[index];
    
    }

    public void filterMovesFor(Cell cell,ArrayList<Cell>moves){

        board = pieceTracker.getTracker();

        int row = cell.getRow();
        int col = cell.getCol();

        ChessPiece piece = getPiece(row,col);
        int index = EnvUtility.getIndex(row, col);

        
        //place piece on each move and check for its validation
        for(Cell currMove:moves){

            board[index]=null;

            int newPosition = EnvUtility.getIndex(currMove.getRow(), currMove.getCol());
            ChessPiece placedPiece = board[newPosition];
            board[newPosition]=piece;

            if(new KingCheck().isKingInCheck(board, Team.BLACK)){
                Log.info(this, "@@@@@@@@@@@@ White king is checked");
            }

            if(new KingCheck().isKingInCheck(board, Team.WHITE)){
                Log.info(this, "@@@@@@@@@@@@ Black king is checked");
            }

            //restore everything
            board[index]=piece;
            board[newPosition]=placedPiece;
        }
    }
}
