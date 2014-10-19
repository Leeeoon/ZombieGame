package zombiegame;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class ContainerPanel extends JPanel implements ActionListener {

    TitlePanel titlePanel;
    EndPanel endPanel;
    GamePanel gamePanel;
    OptionsPanel optionsPanel;
    Timer timer;
    
    public ContainerPanel() {
        
        setLayout(null);
        // Set up titlePanel ------------------------------------------
        titlePanel = new TitlePanel();
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 500, 500);
        titlePanel.startButton.setBounds(225, 300, 50, 50);
        titlePanel.add(titlePanel.startButton);
        add(titlePanel);
        // draw the string (titlePanel.welcomeMsg)
        // ------------------------------------------------------------
        
        gamePanel = new GamePanel();
        
        // Set up optionsPanel ----------------------------------------
        optionsPanel = new OptionsPanel(gamePanel);
        
    }
    
    public void setPanelVisiblity() {
        
        
    }
    
    public void resetValues() {
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    
    }
    
}

