import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TPanel extends JPanel{
    Rectangle squares[]= new Rectangle[64];
    int currPosition=0;
    BufferedImage whitePawns[]=new BufferedImage[8];
    BufferedImage whiteKing,whiteQueen;
    BufferedImage whiteKnightLeft,whiteKnightRight;
    BufferedImage whiteRookLeft,whiteRookRight;
    BufferedImage whiteBishopLeft,whiteBishopRight;


    TPanel(){
        setSize(600, 600);
        //setBackground(Color.BLACK);

        JButton btn = new JButton("forward knight");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Position.kx = 50*6+5;
                Position.ky=50*6+5;
                repaint();
            }
        });
        add(btn);

        // ImageIcon icon = new ImageIcon("/images/pawn.png");
        // JLabel label = new JLabel(icon);

        // JLabel l = new JLabel("this is tpanel label");
        // l.setBounds(50, 50, 50, 50);
        // add(l);

        // add(label);


    }
    public int getIndex(int i,int j){
        int index=(i-1)*8+(j-1);
        return index;
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
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

        //g2d.fill(squares[currPosition]);
        try {
            BufferedImage img2 = ImageIO.read(getClass().getResource("/images/wp.png"));
            
            for(int i=0;i<8;i++){
                whitePawns[i]= resizeImage(img2, 40, 40);
            }
            

            img2 = ImageIO.read(getClass().getResource("/images/whiteRook.png"));
            whiteRookLeft = resizeImage(img2, 40, 40);
            whiteRookRight = resizeImage(img2, 40, 40);

            img2 = ImageIO.read(getClass().getResource("/images/whiteKnight.png"));
            whiteKnightLeft = resizeImage(img2, 40, 40);
            whiteKnightRight = resizeImage(img2, 40, 40);

            img2 = ImageIO.read(getClass().getResource("/images/whiteBishop.png"));
            whiteBishopLeft = resizeImage(img2, 40, 40);
            whiteBishopRight = resizeImage(img2, 40, 40);



            
               
           } catch (IOException e) {
    
            e.printStackTrace();
           }
        
    }

   

    @Override
    public void paint(Graphics g) {
        
        drawRectangle(g);
        //g.drawString("mouse at "+mouseX+","+mouseY,500,500);
        for(int i=0;i<8;i++){
            g.drawImage(whitePawns[i],50*(i+1)+5,50*7+5,null);
        }
        

        //rook
        g.drawImage(whiteRookLeft,Position.whiteRookLeft().x,Position.whiteRookLeft().y,null);
        g.drawImage(whiteRookRight,Position.whiteRookRight().x,Position.whiteRookRight().y,null);

        //knight
        g.drawImage(whiteKnightLeft,Position.whiteKnightLeft().x,Position.whiteKnightLeft().y,null);
        g.drawImage(whiteKnightRight,Position.whiteKnightRight().x,Position.whiteKnightRight().y,null);
        
        //bishop
        g.drawImage(whiteBishopLeft,Position.whiteBishopLeft().x,Position.whiteBishopLeft().y,null);
        g.drawImage(whiteBishopRight,Position.whiteBishopRight().x,Position.whiteBishopRight().y,null);

    }

    
}
