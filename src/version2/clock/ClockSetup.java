package version2.clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import version2.EnvUtility;
import version2.Log;

public class ClockSetup extends JPanel{

    private int timeInMinutes = 2;
    private int incrementInSecond=2;

    private String player1 = "Gyanchandk kewat";
    private String player2 = "Magnus Carlsen ";

    private JLabel whiteTime,blackTime;
    
    
    public ClockSetup(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        setLayout(new BorderLayout());
        
        Font font = new Font("Arial", Font.BOLD, 20);

        blackTime = new JLabel("b-00:00:00");
        blackTime.setFont(font);

        whiteTime = new JLabel("w-00:00:00");
        whiteTime.setFont(font);
        
        

        JLabel bname = new JLabel(player1);
        bname.setFont(font);

        JLabel wname = new JLabel(player2);
        wname.setFont(font);
        
        JPanel topPanel = new JPanel(new GridLayout(1,2,0,0));
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.add(bname);
        topPanel.add(blackTime);
        add(topPanel,BorderLayout.NORTH);

        

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2,0,0));
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(wname);
        bottomPanel.add(whiteTime);
        add(bottomPanel,BorderLayout.SOUTH);

        configureClock();
    }

    private void configureClock(){

        Timer timer = new Timer("clock-timer");
        TimerTask chessClock = new Clock(timeInMinutes*60*1000, 
        incrementInSecond,
        timer,
        whiteTime,blackTime);

        timer.schedule(chessClock,0,1);

        Log.info(this, "Clock setup is done");
    }

}
