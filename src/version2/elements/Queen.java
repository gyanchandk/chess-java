package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class Queen extends ChessPiece{

    ArrayList<Coordinate> moves= new ArrayList<>();

    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public void drawHints(int row, int col) {
        moves.clear();
        
        addBishopRules(row, col);
        addRookRules(row,col);

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);
    }

    public void addBishopRules(int row,int col){
        bishopUtil(row, col, 1, -1);
        bishopUtil(row, col, -1, -1);
        bishopUtil(row,col , -1, 1);
        bishopUtil(row , col, 1, 1);
    }

    private void bishopUtil(int x,int y,int xOffset,int yOffset){

        int nextX=x+xOffset;
        int nextY= y+yOffset;
        
        while(EnvUtility.check(nextX, nextY)){

            if(rules.checkForSameTeam(x, y, nextX, nextY)){
                moves.add(new Coordinate(nextX, nextY));
            }
            else{
                break;
            }

            if(pt.getInfo(nextX, nextY)!=null){
                break;
            }

            nextX=nextX+xOffset;
            nextY=nextY+yOffset;
        }
    }

    public void addRookRules(int row,int col){
        //to-left
        for(int nextY=col-1;nextY>=1;nextY--){
            if(EnvUtility.check(row, nextY)){

                if(rules.checkForSameTeam(row, col, row, nextY)){
                    moves.add(new Coordinate(row, nextY));
                }
                else{
                    break;
                }

                if(pt.getInfo(row, nextY)!=null){
                    break;
                }
            }
        }
        
        //to-right
        for(int nextY=col+1;nextY<=8;nextY++){
            if(EnvUtility.check(row, nextY)){

                if(rules.checkForSameTeam(row, col, row, nextY)){
                    moves.add(new Coordinate(row, nextY));
                }
                else{
                    break;
                }

                if(pt.getInfo(row, nextY)!=null){
                    break;
                }

                
                
            }
        }
        //to-down
        for(int nextX=row+1; nextX<=8;nextX++){
            if(EnvUtility.check(nextX, col)){

                if(rules.checkForSameTeam(row, col, nextX, col)){
                    moves.add(new Coordinate(nextX,col));
                }
                else{
                    break;
                }

                if(pt.getInfo(nextX, col)!=null){
                    break;
                }
            }
        }
        
        //to-up
        for(int nextX=row-1; nextX>=1;nextX--){
            if(EnvUtility.check(nextX, col)){

                if(rules.checkForSameTeam(row, col, nextX, col)){
                    moves.add(new Coordinate(nextX,col));
                }
                else{
                    break;
                }

                if(pt.getInfo(nextX, col)!=null){
                    break;
                }
            }
        }

    }

    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }
    
}
