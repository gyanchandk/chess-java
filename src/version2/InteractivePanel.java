package version2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import version2.elements.King;

public class InteractivePanel extends JPanel implements MouseListener{

    PieceTracker pt = PieceTracker.getInstance();
    HightLightLayer hl = HightLightLayer.getInstance();
    PieceLayer pieceLayer = PieceLayer.getInstance();
    ChessRules rules = ChessRules.getInstance();
    private GameControl control = GameControl.getInstance();

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

    public void handleCastling(int row,int newRow,int newCol){

        if(row!=newRow)return;

        if(newCol!=3 && newCol!=7){
            return;
        }

        

        if(newCol==3){
            //a side castling
            ChessPiece aRook = pt.getInfo(row, 1);

            pt.updatePiecePos(row, 1, row,4,aRook);

            

        }

        if(newCol==7){
            //h side castling
            ChessPiece hRook = pt.getInfo(row, 8);

            pt.updatePiecePos(row, 8,row,6, hRook);
        }

        System.out.println("@@@@@@@@@@@@@@@@castling has done");
        control.changeTurn();


    }
    public void requestForPieceMove(int newRow,int newCol){

        
        int row=prevState.getX();
        int col = prevState.getY();

        if(!rules.validate(row,col,newRow,newCol)){
            return;
        }

        ChessPiece piece = pt.getInfo(row, col);

        boolean legalMove= pt.updatePiecePos(row, col, newRow,newCol,piece);

        //special case of castling
        if(piece instanceof King){
            
            if(legalMove)
                handleCastling(row, newRow, newCol);

        }

        if(legalMove){
            pieceLayer.repaint();
        }

        

    }

    public boolean checkForTurn(int row,int col){
        ChessPiece piece = pt.getInfo(row, col);

        if(piece==null)return false;

        if(piece.getTeam()!=control.getNextTurn()){
            return false;
        }

        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        

        int row= e.getY()/50;
        int col=e.getX()/50;
        
        if(!check(row, col))return;

        hl.setHighlightSquare(row, col);

        System.out.println("===turn==:"+control.getNextTurn());

        if(!hintOn){
            if(!checkForTurn(row, col))return;
        }
       



        if(hintOn){
            requestForPieceMove(row,col);
            hintOn=false;
            pt.updatePermissibleCells(null);
            return;
        }

        hintOn=false;
        pt.updatePermissibleCells(null);

        

       

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
