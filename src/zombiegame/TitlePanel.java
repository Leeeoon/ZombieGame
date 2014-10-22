package zombiegame;

import javax.swing.*;
import java.awt.Graphics;

public class TitlePanel extends JPanel {
    String welcomeMsg = "Welcome to the Zombie Game!";
    String rules1 = "The goal of this game is to collect all ";
    String rules2 = "four coins while avoiding the zombie.";
    String rules3 = "If the zombie catches you, it's all over!";
    JButton startButton = new JButton ("Start");               // For the initial load/welcome screen
    //add(startButton);                                        //Problem getting this to work
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(welcomeMsg, 160, 200);
        g.drawString(rules1, 140, 220);
        g.drawString(rules2, 140, 240);
        g.drawString(rules3, 137, 260);
    }
}


