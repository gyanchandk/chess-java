package version2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import version2.factory.Piece;

public abstract class ChessPiece {
    protected String imagePath;
    protected BufferedImage pieceImg;
    protected int width = EnvUtility.width;
    
    protected Piece pieceType;
    protected int pieceValue;
    protected Team team;
    protected boolean hasMoved;
    protected int moveCount=0;
    protected PieceTracker pieceTracker = Game.getPieceTracker();

    abstract public String getName();
    abstract public ArrayList<Cell> getMovesFor(int row, int col);

    public int getPieceValue() {
        return pieceValue;
    }

    public Piece getPieceType() {
        return pieceType;
    }

    public Team getTeam() {
        return team;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
        this.moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }

    public BufferedImage getPieceImg(){
        loadImage(imagePath);
        return pieceImg;

    }

    public boolean isOpponentAt(ChessPiece piece,int row,int col){

        //TODO:change piece to this.get...

        Log.info(this, "Isopponent is called");
        if(piece == null){
            Log.error(this, "Seeking opponent for null piece");
        }

        ChessPiece targetPiece = pieceTracker.getInfo(row, col);
        if(targetPiece==null)return false;
        Team targetTeam = targetPiece.getTeam();

        return (targetTeam!=piece.getTeam());
    }


    public void loadImage(String imagePath){
        try {
            BufferedImage img= ImageIO.read(getClass().getResource(imagePath));
            pieceImg = EnvUtility.resizeImage(img, width, width);
        
        } catch (IOException e) {
    
            e.printStackTrace();
        }
    }

    
}

