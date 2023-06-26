package version2.elements;

import java.util.ArrayList;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;
import version2.Log;
import version2.Team;
import version2.rules.KingCheck;

public class King extends ChessPiece {

    protected int pieceValue = Integer.MAX_VALUE;
    protected boolean aCastle=false;
    protected boolean hCastle = false;

    @Override
    public String getName() {
        return "King";
    }

    public void setaCastle(boolean aCastle) {
        this.aCastle = aCastle;
    }

    public void sethCastle(boolean hCastle) {
        this.hCastle = hCastle;
    }
    
    public boolean getACastleStatus(){
        return aCastle;
    }

    public boolean getHCastleStatus(){
        return hCastle;
    }

    @Override
    public ArrayList<Cell> getMovesFor(int row, int col) {
        ArrayList<Cell> moves = new ArrayList<>();

        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){

            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX,nextY) ){
                ChessPiece piece =pieceTracker.getInfo(nextX, nextY);


                if(piece == null){
                    moves.add(new Cell(nextX, nextY));
                    continue;
                }

                if(piece.getTeam()!=this.getTeam()){
                    moves.add(new Cell(nextX, nextY));
                    continue;
                }

            }
        }

        if(isCastelingAvailableWithRook(row, 8)){
            Log.info(this, "Castling available with H-rook , king checks are not taken care");
            moves.add(new Cell(row, 7));
            hCastle = true;
        }else{
            hCastle = false;
        }

        if(isCastelingAvailableWithRook(row, 1)){
            Log.info(this, "Castling available with A-rook,king checks are not taken care");
            moves.add(new Cell(row, 3));
            aCastle=true;
        }else{
            hCastle=false;
        }

        return moves;
    }

    public boolean isCastelingAvailableWithRook(int row,int rookCol){
        if(hasMoved)return false;

        ChessPiece rook= pieceTracker.getInfo(row, rookCol);

        if(rook==null)return false;

        if(rook.getHasMoved())return false;

        int colOffset=1; //default for hrook
        if(rookCol<5){
            colOffset=-1;
        }

        int currCol = 5+colOffset;
        while(currCol!=rookCol){
            ChessPiece piece = pieceTracker.getInfo(row, currCol);

            if(piece!=null)return false;

            currCol+=colOffset;
        }

        //check is intermediate moves does not involves check

        ChessPiece []board = pieceTracker.getTracker();

        int index = EnvUtility.getIndex(row, 5);
        board[index]=null;
        if(row==1){

            int newIndex = EnvUtility.getIndex(row, 5+colOffset);
            board[newIndex]=this;
            if(new KingCheck().isKingInCheck(board, Team.WHITE)){

                return false;
            }
        }

        else if(row==8){

            int newIndex = EnvUtility.getIndex(row, 5+colOffset);
            board[newIndex]=this;
            if(new KingCheck().isKingInCheck(board, Team.BLACK)){
                return false;
            }

        }

        return true;
    }
    
        
}
