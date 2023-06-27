package version2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class InteractivePanel extends JPanel implements MouseListener{

    private int width = EnvUtility.width;
    private ArrayList<Observer> observers = new ArrayList<>();

    InteractivePanel(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        addMouseListener(this);

    }

    public void attach(Observer observer){
        observers.add(observer);
    }
    
    private void sendCellDetailsToAll(Cell cell){
        for(Observer observer:observers){
            observer.update(cell);
        }
    }

    public boolean isClickedOnBoard(int row,int col){
        if(row>=1 && row<=8 && col>=1 && col<=8)
            return true;

        return false;
    }

    


    @Override
    public void mouseClicked(MouseEvent e) {
        int row= e.getY()/width;
        int col=e.getX()/width;

        if(!isClickedOnBoard(row, col)){
            Log.info(this, "Clicked out of board");
            return ;
        }

        //Log.info(this, "Clicked on:"+row+","+col);

        sendCellDetailsToAll(new Cell(row,col));

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
