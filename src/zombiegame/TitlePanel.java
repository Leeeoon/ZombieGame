package zombiegame;

import javax.swing.*;
import java.awt.Graphics;

public class TitlePanel extends JPanel {
    String welcomeMsg = "Welcome to the Zombie Game";
    JButton startButton = new JButton ("Start");               // For the initial load/welcome screen
    //add(startButton);                                        //Problem getting this to work
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(welcomeMsg, 50, 50);
    }
}


