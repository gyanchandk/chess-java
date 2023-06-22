package version2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class InteractivePanel extends JPanel implements MouseListener{

    PieceTracker pt = PieceTracker.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();

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

    @Override
    public void mouseClicked(MouseEvent e) {
        int row= e.getY()/50;
        int col=e.getX()/50;
        
        if(!check(row, col))return;

        hl.setHighlightSquare(row, col);

        ChessPiece piece = pt.getInfo(row, col);

        if(piece!=null)
            piece.drawHints(row,col);

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
