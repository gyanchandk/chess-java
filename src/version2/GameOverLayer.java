package version2;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverLayer extends JPanel{
    
    private JLabel label;

    public GameOverLayer(){
        setSize(EnvUtility.getPanelDimension());
        setOpaque(false);
        setLayout(new BorderLayout());

        label = new JLabel("");
        label.setFont(new Font("Arial", Font.BOLD, 30));

        

        add(label,BorderLayout.CENTER);
    }

    public void setGameOverMsg(String msg){
        label.setText(msg);
    }
}
