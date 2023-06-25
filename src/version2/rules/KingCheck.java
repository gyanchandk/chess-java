package version2.rules;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;
import version2.Log;
import version2.Team;
import version2.elements.Bishop;
import version2.elements.King;
import version2.elements.Knight;
import version2.elements.Pawn;
import version2.elements.Queen;
import version2.elements.Rook;


public class KingCheck {

    private ChessPiece []board;

    public ChessPiece getPiece(int row,int col){

        int index=EnvUtility.getIndex(row, col);
        return board[index];
    
    }

    private Cell getKingCell(Team targetTeam){

        Cell cell = new Cell(0, 0);

        for(int row=1;row<=8;row++){
            for(int col=1;col<=8;col++){
                ChessPiece piece = getPiece(row, col);

                if(piece==null)continue;

                if(piece.getTeam()!=targetTeam)continue;

                if(piece instanceof King){
                    return new Cell(row, col);
                }
            }
        }

        return cell;
    }
    
    public boolean isKingInCheck(ChessPiece []board,Team targetTeam){

        
        this.board = board;

        Cell kingCell =  targetTeam ==Team.WHITE?
            getKingCell(Team.BLACK):getKingCell(Team.WHITE);

        int row = kingCell.getRow();
        int col = kingCell.getCol();

        if(isCheckedByPawn(row-1, col-1,targetTeam) ||
        isCheckedByPawn(row-1, col+1,targetTeam) ){
            Log.info(this, "king is checked by"+targetTeam+"pawn");
        }

        if(isCheckedByBishop(row, col,targetTeam)){
            Log.info(this, " king is checked by "+targetTeam+" bishop/black Queen");
        }

        if(isCheckedByRook(row, col, targetTeam)){
            Log.info(this, " king is checked by "+targetTeam+" rook/black Queen");
        }


        if(isCheckedByKnight(row, col, targetTeam)){
            Log.info(this, " king is checked by "+targetTeam+" knight");
        }

        if(isCheckedByKing(row, col, targetTeam)){
            Log.info(this," king is checked by "+targetTeam+" King");
        }

        return false;
    }

    private boolean isCheckedByPawn(int row,int col,Team targetTeam){

        if(!EnvUtility.check(row , col)){
            return false;
        }
        
        ChessPiece piece = getPiece(row, col);

        if(piece==null){
            return false;
        }

        if(piece.getTeam()!=targetTeam){
                return false;
        }

        if(piece instanceof Pawn){
            return true;
        }

        return false;
    }

    private boolean isCheckedByBishop(int row,int col,Team targetTeam){

        if(bishopUtil(row, col, 1, -1,targetTeam) ||
        bishopUtil(row, col, -1, -1,targetTeam) ||
        bishopUtil(row,col , -1, 1,targetTeam) ||
        bishopUtil(row , col, 1, 1,targetTeam)){

            return true;
        }

        return false;

    }

    private boolean bishopUtil(int x,int y,int xOffset,int yOffset,Team targetTeam){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){

            ChessPiece piece = getPiece(nextX, nextY);

            if(piece==null){
                nextX=nextX+xOffset;
                nextY=nextY+yOffset;
                continue;
            }

            if(piece.getTeam()!=targetTeam){
                return false;
            }

            if(piece instanceof Bishop || piece instanceof Queen){
                return true;

            }else{
                return false;
            }

            
        }

        return false;
    }

    private boolean isCheckedByRook(int row,int col,Team targetTeam){

        //left right top bottom

        if(rookUtil(row, col, 0, -1,targetTeam) ||
        rookUtil(row, col, 0, 1,targetTeam) ||
        rookUtil(row,col , -1, 0,targetTeam) ||
        rookUtil(row , col, 1, 0,targetTeam)){

            return true;
        }

        return false;

    }

    private boolean rookUtil(int x,int y,int xOffset,int yOffset,Team targetTeam){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){

            ChessPiece piece = getPiece(nextX, nextY);

            if(piece==null){
                nextX=nextX+xOffset;
                nextY=nextY+yOffset;
                continue;
            }

            if(piece.getTeam()!=targetTeam){
                return false;
            }

            if(piece instanceof Rook || piece instanceof Queen){
                return true;

            }else{
                return false;
            }

            
        }

        return false;
    }
    

    private boolean isCheckedByKnight(int row,int col,Team targetTeam){

        int xOffset[]={-2,-2,-1,-1,1,1,2,2};
        int yOffset[]={1,-1,2,-2,2,-2,1,-1};

        for(int i=0;i<8;i++){

            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX,nextY) ){
                ChessPiece piece =getPiece(nextX, nextY);

                if(piece == null)continue;

                if(piece.getTeam()!=targetTeam)continue;

                if(piece instanceof Knight){
                    return true;
                }

            }
        }

        return false;

    }

    private boolean isCheckedByKing(int row,int col,Team targetTeam){


        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){

            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX,nextY) ){
                ChessPiece piece =getPiece(nextX, nextY);


                if(piece == null)continue;

                if(piece.getTeam()!=targetTeam)continue;

                if(piece instanceof King){
                    return true;
                }

            }
        }

        return false;
    }
}
