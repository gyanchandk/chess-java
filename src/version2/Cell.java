package version2;

import java.util.ArrayList;

public class Cell {
    private int row, col;

    public Cell(int row,int col){
        this.row=row;
        this.col=col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Cell:("+row+","+col+")";
    }

    public static void printMoves(ArrayList<Cell> moves){
        for(Cell cell:moves){
            System.out.println(cell);
        }
    }
}
