package version2.chessEngine;

import java.util.ArrayList;
import java.util.Random;

import version2.Cell;
import version2.ChessPiece;
import version2.Game;
import version2.GameStatus;
import version2.HightLightLayer;
import version2.Log;
import version2.PieceTracker;
import version2.Team;
import version2.layers.HintLayer;
import version2.rules.KingCheck;
import version2.rules.LegalMove;

public class SimpleEngine {

    private PieceTracker pieceTracker;
    private ArrayList<Cell> hintCells = new ArrayList<>();
    private HintLayer hintLayer;
    private HightLightLayer hightLightLayer = Game.getHightLightLayer();

    public SimpleEngine(HintLayer hintLayer,PieceTracker pieceTracker){
        this.hintLayer = hintLayer;
        this.pieceTracker = pieceTracker;
    }

    public void makeMove(){
        if(Game.getTurn()!=Team.BLACK)return;

        Log.info(this, "Make move attempted");

        hintCells=null;

        ArrayList<Cell> blackCells = new ArrayList<>();

        for(int row=1;row<=8;row++){
            for(int col=1;col<=8;col++){
                
                ChessPiece piece=pieceTracker.getInfo(row, col);

                if(piece==null)continue;

                if(piece.getTeam()==Team.BLACK){
                    if(cellHasALegalmove(row, col, piece)){
                        blackCells.add(new Cell(row, col));
                    }
                    
                }
            }
        }

        if(blackCells.size()<=0){
            Game.setGameStatus(GameStatus.GAME_OVER);
            Log.info(this, "Game is over/ White wins");
            return;
        }

        int bound = blackCells.size();
        Random random = new Random();

        Log.info(this, "bound is:"+bound);

        int index = random.nextInt(bound);
        int currRow = blackCells.get(index).getRow();
        int currCol = blackCells.get(index).getCol();

        ChessPiece piece = pieceTracker.getInfo(currRow,currCol);

        hintCells = piece.getMovesFor(currRow, currCol);
        hintCells = new LegalMove().filterMovesFor(new Cell(currRow, currCol), hintCells);


        //Log.info(this, "random index is:"+index+ "selected piece:"+piece.getName()+"  hintcells size:"+hintCells.size());

        int randomMove = random.nextInt(hintCells.size());

        Cell.printMoves(hintCells);

        hightLightLayer.update(blackCells.get(index));
        attemptMove(blackCells.get(index), hintCells.get(randomMove));


    }

    public boolean cellHasALegalmove(int row,int col,ChessPiece piece){

        ArrayList<Cell> hCells = new ArrayList<>();
        
        hCells = piece.getMovesFor(row, col);
        hCells = new LegalMove().filterMovesFor(new Cell(row, col), hCells);

        if(hCells.size()>0){
            return true;
        }

        return false;
    }

    public void attemptMove(Cell selectedCell,Cell cell){

        Log.info(this, "from :"+selectedCell+" to :"+cell);

        

        Cell kingCell;
        //selected cell is move from; cell is moveto
        pieceTracker.updatePiecePos(selectedCell.getRow(), selectedCell.getCol(), cell.getRow(), cell.getCol());
            hintCells=null;

            Game.changeTurn();

            if(Game.getTurn() == Team.WHITE){
                if(new KingCheck().isKingInCheck(pieceTracker.getTracker(), Team.BLACK)){
                    kingCell = KingCheck.getKingCell(Team.WHITE);
                    hintLayer.setKingCell(kingCell);
                }else{
                    kingCell=null;
                    hintLayer.setKingCell(kingCell);
                }
            }

            if(Game.getTurn() == Team.BLACK){
                if(new KingCheck().isKingInCheck(pieceTracker.getTracker(), Team.WHITE)){
                    kingCell = KingCheck.getKingCell(Team.BLACK);
                    hintLayer.setKingCell(kingCell);
                }else{
                    kingCell=null;
                    hintLayer.setKingCell(kingCell);
                }
            }
    }
    
}




