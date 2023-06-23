package version2;

import java.util.ArrayList;


public class ChessRules {

    private static ChessRules instance = new ChessRules();
    private PieceTracker pt = PieceTracker.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();
    private ChessRules(){

    }
    public static ChessRules getInstance(){
        return instance;
    }



    public boolean validate(int row,int col,int newRow,int newCol){

        ArrayList<Coordinate> cells = pt.getPermissibleCells();

        System.out.println("Permissible squares:");
        for(Coordinate c:cells){
            //System.out.println(c.getX()+","+c.getY());

            if(newRow == c.getX() && newCol == c.getY()){
                System.out.println(newRow+","+newCol+ " is permitted");
                return true;
            }
        }
        
        return false;
    }

    public boolean checkForSameTeam(int row,int col,int newRow,int newCol){

        //System.out.println("called for :"+row+","+col+","+newRow+","+newCol);
        //System.err.println("pieces are ================="+pt.getInfo(row, col)+","+pt.getInfo(newRow, newCol));

        if(pt.getInfo(row, col)==null){
            System.out.println("team check called for:"+row+","+col+ "  ERROR!!!!!!");
        }

        Team team = pt.getInfo(row, col).getTeam();

        if(pt.getInfo(newRow, newCol)==null){
            return true;
        }
        else{

            Team targetTeam = pt.getInfo(newRow, newCol).getTeam();
            if(team !=targetTeam){
                return true;
            }
        }

        return false;
    }

    public boolean foundPieceInMoves( ArrayList<Coordinate> moves,ChessPiece piece){

        return false;

    }

}
