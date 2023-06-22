package version2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class InteractivePanel extends JPanel implements MouseListener{

    PieceTracker pt = PieceTracker.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();
    PieceLayer pieceLayer = PieceLayer.getInstance();
    ChessRules rules = ChessRules.getInstance();

    private boolean hintOn=false;
    private Coordinate prevState;

    InteractivePanel(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        addMouseListener(this);
    }

    public boolean check(int row,int col){
        if(row<1 || row>8 || col<1 || col>8)
            return false;

        return true;
    }

    public void requestForPieceMove(int newRow,int newCol){

        
        int row=prevState.getX();
        int col = prevState.getY();

        if(!rules.validate(row,col,newRow,newCol)){
            return;
        }

        ChessPiece piece = pt.getInfo(row, col);

        

        pt.updatePiecePos(row, col, null);
        pt.updatePiecePos(newRow, newCol, piece);

        pieceLayer.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        

        int row= e.getY()/50;
        int col=e.getX()/50;
        
        if(!check(row, col))return;

        if(hintOn){
            requestForPieceMove(row,col);
            hintOn=false;
            pt.updatePermissibleCells(null);
            return;
        }

        hintOn=false;
        pt.updatePermissibleCells(null);

        

        hl.setHighlightSquare(row, col);

        ChessPiece piece = pt.getInfo(row, col);

        if(piece!=null){
            piece.drawHints(row,col);
            prevState = new Coordinate(row, col);
            hintOn = true;
        }
            
        System.out.println("hint is on:"+hintOn);
        

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
