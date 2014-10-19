package zombiegame;

import java.awt.*;
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
        titlePanel.startButton.addActionListener(this);
        titlePanel.add(titlePanel.startButton);
        add(titlePanel);
        // draw the string (titlePanel.welcomeMsg)
        // ------------------------------------------------------------
    
        gamePanel = new GamePanel();
        
        // Set up optionsPanel ----------------------------------------
        optionsPanel = new OptionsPanel(gamePanel);
        optionsPanel.setVisible(false);
        optionsPanel.setLayout(null);
        optionsPanel.setBounds(0, 0, 500, 500);
        
        // Hero options
        // ---- Choose your hero
        optionsPanel.heroButtons.setBounds(25, 50, 165, 30);
        optionsPanel.add(optionsPanel.heroButtons);
        // ---- Hero option 1
        optionsPanel.hero1.setBounds(200, 40, 50, 50);
        optionsPanel.add(optionsPanel.hero1);
        
        // Background options
        // ---- Choose background
        optionsPanel.backgroundButtons.setBounds(25, 130, 165, 30);
        optionsPanel.add(optionsPanel.backgroundButtons);
        // ---- Background option 1
        optionsPanel.background1.setBounds(200, 120, 50, 50);
        optionsPanel.add(optionsPanel.background1);
        
        // Difficulty options
        optionsPanel.difficultyButtons.setBounds(25, 210, 165, 30);
        optionsPanel.add(optionsPanel.difficultyButtons);
        // Difficulty: easy
        optionsPanel.easy.setBounds(200, 210, 100, 30);
        optionsPanel.add(optionsPanel.easy);
        // Difficulty: hard
        optionsPanel.hard.setBounds(300, 210, 100, 30);
        optionsPanel.add(optionsPanel.hard);
        
        // Begin game button
        optionsPanel.beginGameButton.setBounds(200, 300, 100, 75);
        optionsPanel.add(optionsPanel.beginGameButton);
        optionsPanel.beginGameButton.addActionListener(this);
        
        add(optionsPanel);
        // ------------------------------------------------------------
        
        // Set up game panel ------------------------------------------
        gamePanel.setLayout(null);
        gamePanel.setVisible(false);
        gamePanel.setBounds(0, 0, 500, 400);
        add(gamePanel);
        
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
    
        if (e.getSource() == titlePanel.startButton)
        {
            titlePanel.setVisible(false);
            System.out.println("Title panel invisible");
            optionsPanel.setVisible(true);
            System.out.println("Options panel visible");
        }
        
        if (e.getSource() == optionsPanel.beginGameButton)
        {
            optionsPanel.setVisible(false);
            System.out.println("Options panel invisible");
            gamePanel.setVisible(true);
            System.out.println("Game panel visible");
        }
    
    }
    
}

