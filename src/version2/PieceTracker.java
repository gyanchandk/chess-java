package version2;

import java.util.ArrayList;

public class PieceTracker {
    private ChessPiece  tracker[] = new ChessPiece[64];
    private static PieceTracker instance = new PieceTracker();
    private ArrayList<Coordinate> permissibleCells = new ArrayList<>();

    private PieceTracker(){

    }
    public static PieceTracker getInstance(){
        return instance;

    }

    public void updatePiecePos(int row, int col, ChessPiece piece){
        int index = EnvUtility.getIndex(row, col);
        tracker[index]=piece;
    }

    public ChessPiece getInfo(int row,int col){
        int index=EnvUtility.getIndex(row, col);
        return tracker[index];
    }

    public void updatePermissibleCells(ArrayList<Coordinate> cells ){
        permissibleCells = cells;
    }

    public ArrayList<Coordinate> getPermissibleCells(){
        return permissibleCells;
    }
}
