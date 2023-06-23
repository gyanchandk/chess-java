package version2.elements;

import java.util.ArrayList;

import version2.ChessPiece;
import version2.Coordinate;
import version2.EnvUtility;
import version2.HightLightLayer;
import version2.PieceTracker;
import version2.Team;

public class King extends ChessPiece {

    ArrayList<Coordinate> moves= new ArrayList<>();

    private PieceTracker pt = PieceTracker.getInstance();
    private HightLightLayer hl = HightLightLayer.getInstance();
    protected boolean hasMoved=false;
    
    @Override
    public String getName() {
        return "King";
    }

    

    @Override
    public void drawHints(int row, int col) {
        System.out.println(getName()+":"+getMovedStatus());
        moves.clear();
        int xOffset[]={-1,0,1,-1,1,-1,0,1};
        int yOffset[]={-1,-1,-1,0,0,1,1,1};

        for(int i=0;i<8;i++){
            int nextX= row+xOffset[i];
            int nextY = col+yOffset[i];

            if(EnvUtility.check(nextX, nextY)){
                if(rules.checkForSameTeam(row, col, nextX, nextY)){
                    moves.add(new Coordinate(nextX, nextY));
                }
                
            }

            
            
        }

        addHintsForCastling(row);

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);
    }

    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }

    public boolean checkForEmptySquares(int row,int start,int end){

        for(int col=start;col<=end;col++){
            if(pt.getInfo(row, col)!=null){
                return false;
            }
        }
        
        return true;
    }
    public boolean checkForARook(int row){
        //check for a rook
        ChessPiece aRook = pt.getInfo(row, 1);

        if(aRook!=null){
            System.out.println("aRook:"+aRook.getMovedStatus());
            if(!aRook.getMovedStatus() && checkForEmptySquares(row, 2, 4)){
                return true;
            }
        }

        return false;
    }

    public boolean checkForHRook(int row){
        //check for a rook
        ChessPiece hRook = pt.getInfo(row, 8);

        if(hRook!=null){
            System.out.println("hRook:"+hRook.getMovedStatus());
            if(!hRook.getMovedStatus() && checkForEmptySquares(row, 6, 7)){
                return true;
            }
        }

        return false;
    }
    public void addHintsForCastling(int row){

        if(hasMoved)return;
        //king will be in 5th col

        if(checkForARook(row)){
            System.out.println("******* castling allowed with a rook");
            moves.add(new Coordinate(row, 3));
        }

        if(checkForHRook(row)){
            System.out.println("******* castling allowed with h rook");
            moves.add(new Coordinate(row, 7));
        }


    }
        
}
