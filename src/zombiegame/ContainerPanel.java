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
        
        titlePanel = new TitlePanel();
        endPanel = new EndPanel();
        gamePanel = new GamePanel();
        optionsPanel = new OptionsPanel(gamePanel);
        //timer = new Timer();                          // will deal with later
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
    }
    
    public void setPanelVisiblity() {
        
        
    }
    
    public void resetValues() {
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    
    }
    
}

