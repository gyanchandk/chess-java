package version2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PieceLayer extends JPanel{

    PieceLayer(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    public void addAllPieces(Graphics g){
        //pawns
        Pawn pawn = new Pawn();
        pawn.addWhitePawns(g);

        //knights
        Knight knight = new Knight();
        knight.addWhiteKnights(g);

    }


    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        addAllPieces(g);

    }


    
}
