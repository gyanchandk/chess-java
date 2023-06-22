import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class ChessBoard extends JPanel{
    ChessPiece board[] = new ChessPiece[64];
    Rectangle squares[]= new Rectangle[64];
    private int width=50;

    ChessBoard(){

        setSize(600, 600);
       

        putWhitePawns();
        putWhiteKing();
        putWhiteQueens();
        putWhiteRooks();
        putWhiteBishops();
        putWhiteKnights();
    
    }

    public int getIndex(int i,int j){
        int index=(i-1)*8+(j-1);
        return index;
    }
    public void drawRectangle(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.BLACK);
        

        int width=50;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                int xOffset=j*width;
                int yOffset = i*width;
                Rectangle r = new Rectangle(xOffset, yOffset, width, width);
                
                squares[getIndex(i, j)]=r;

                g2d.draw(r);
                if((i+j)%2!=0){
                   g2d.fill(r); 
                }
                
            }
        }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangle(g);

    }
    

    public ChessPiece getPiece(int row, int col){
        int index = Utility.getIndex(row, col);
        return board[index];
    }

    public void putPieceOnBoard(int row, int col, ChessPiece piece){
        int index = Utility.getIndex(row, col);
        board[index]=piece;
    }

    public void putWhitePawns(){
        //2nd rank
        for(int row=7,col=1;col<=8;col++){
            putPieceOnBoard(row,col,new Pawn());
        }

    }
    public void putWhiteBishops(){
        putPieceOnBoard(8, 3 ,new Bishop());
        putPieceOnBoard(8, 6 ,new Bishop());

    }
    public void putWhiteKnights(){

    }
    public void putWhiteRooks(){

    }

    public void putWhiteKing(){

    }

    public void putWhiteQueens(){

    }
}
