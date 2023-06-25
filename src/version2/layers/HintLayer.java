package version2.layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import version2.Cell;
import version2.ChessPiece;
import version2.EnvUtility;
import version2.Game;
import version2.InteractivePanel;
import version2.Observer;
import version2.PieceTracker;
import version2.rules.LegalMove;

public class HintLayer extends JPanel implements Observer{

    private PieceTracker pieceTracker;
    private ArrayList<Cell> hintCells;
    private Cell selectedCell = new Cell(0, 0);
    private final Color focusColor = EnvUtility.getHintColor();
    private final int width = EnvUtility.width;
    private final int margin = 2;

    public HintLayer(InteractivePanel interactivePanel,PieceTracker pieceTracker){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        interactivePanel.attach(this);
        this.pieceTracker = pieceTracker;
    }

    private void drawHints(Graphics g,Cell highLightSquare){
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(focusColor);

        Cell cell = EnvUtility.coordToXY(highLightSquare.getRow(), highLightSquare.getCol());
        Rectangle rectangle = new Rectangle(
            cell.getRow()+margin,
            cell.getCol()+margin,
            width-2*margin,
            width-2*margin);

        g2d.fill(rectangle);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(hintCells!=null){

            new LegalMove().filterMovesFor(selectedCell, hintCells);

            for(Cell cell:hintCells){
                drawHints(g,cell);
            }
        }
    }

    public boolean cellIsInMoves(Cell cell){
        for(Cell c: hintCells){
            if(c.isequalto(cell)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void update(Cell cell) {

        //Draw hints only when piece is not null and piece is of correct team

        int row = cell.getRow();
        int col = cell.getCol();

        ChessPiece piece = pieceTracker.getInfo(row,col);

        if(hintCells!=null && cellIsInMoves(cell)){
            pieceTracker.updatePiecePos(selectedCell.getRow(), selectedCell.getCol(), cell.getRow(), cell.getCol());
            hintCells=null;
            Game.changeTurn();
            return;
        }

        if(piece==null){
            System.out.println("@@@@@@@@Piece is null");
            return;
        }

        if(piece.getTeam()!=Game.getTurn()){
            System.out.println("@@@@@@@@ Its not my turn");
            return;
        }

        selectedCell = cell;

        hintCells = piece.getMovesFor(row, col);
        repaint();

    }
    
}
