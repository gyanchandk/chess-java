package version2.player;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerClock extends JPanel{
    private JLabel playerName ;
    private JLabel time;
    
    public PlayerClock(){
        setSize(400, 50);
        setBackground(Color.MAGENTA);

        playerName = new JLabel("Nihal Sarin  | ");

        time = new JLabel("00:00:00");

        add(playerName);
        add(time);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


    }
}
