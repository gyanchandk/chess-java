package version2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import version2.elements.King;

public abstract class ChessPiece {
    abstract public String getName();
    abstract public Team getTeam();

    protected BufferedImage pieceImg;
    protected int width = EnvUtility.width;
    protected boolean hasMoved=false;

    protected PieceTracker pt = PieceTracker.getInstance();
    protected HightLightLayer hl = HightLightLayer.getInstance();
    protected ChessRules rules = ChessRules.getInstance();

    public void drawHints(int row, int col) {
        ArrayList<Coordinate> moves= new ArrayList<>();

        getMoves(row, col, moves);

        System.out.println("moves before filter:");
        Coordinate.printMoves(moves);

        moves=filterMoves(row, col, moves);

        if(this instanceof King){
            moves = filterCastleMoves(moves);
        }

        

        hl.showHints(moves);
        pt.updatePermissibleCells(moves);

    }
    
    public ArrayList<Coordinate>  filterMoves(int row,int col,ArrayList<Coordinate> moves){

        ArrayList<Coordinate> filteredMoves= new ArrayList<>();

        for(Coordinate c:moves){
            int newRow=c.getX();
            int newCol =c.getY();

            ChessPiece targetPiece = pt.getInfo(newRow, newCol);
            
            pt.updatePiecePos(row,col,null);
            pt.updatePiecePos(newRow, newCol, this);
            

            if(rules.checkMoveValidity(this)){
                filteredMoves.add(c);
            }else{
                System.out.println("NOT PASSED-------------"+newRow+","+newCol+" does not pass the filter");
            }

            

            //revertBack
            pt.updatePiecePos(row,col,this);
            pt.updatePiecePos(newRow, newCol, targetPiece);

        }

        System.out.println("Filtered list is:");
        for(Coordinate c:filteredMoves){
            System.out.println(c);
        }
        return filteredMoves;

    }

    public void setMoved(){
        
        hasMoved = true;
        System.out.println("########### moved :"+getName()+":"+hasMoved);
    }

    public boolean getMovedStatus(){
        return hasMoved;
    }
    
    public void resetMovedStatus(){
        
        hasMoved=false;
        System.out.println(getName()+":"+hasMoved);
    }

    public void loadImage(String imagePath){
        try {
            BufferedImage img= ImageIO.read(getClass().getResource(imagePath));
            pieceImg = EnvUtility.resizeImage(img, width, width);
        
        } catch (IOException e) {
    
            e.printStackTrace();
        }
    }

    public void addImgToPieceLayer(Graphics g, int row,int col){

        Coordinate c;
        c = EnvUtility.coordToXY(row,col);
        g.drawImage(pieceImg, c.getX(), c.getY(), null);
        
    }

    public abstract void getMoves(int row,int col,ArrayList<Coordinate> moves);

    public abstract ArrayList<Coordinate> filterCastleMoves(ArrayList<Coordinate> moves);
}

