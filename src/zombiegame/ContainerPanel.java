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
    int delay;                                                          //For setting the background color
    //--------------------------------------------------------------------------For setting the background color
    Color color = Color.BLUE;
    Color squareColor = Color.blue;

    public ContainerPanel() {

        // Set up timer
        delay = 20; // default for easy
        timer = new Timer(delay, this);
       // timer.start();

        setLayout(null);
        // Set up titlePanel ------------------------------------------
        titlePanel = new TitlePanel();
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 500, 500);

        titlePanel.startButton.setBounds(200, 300, 100, 50);
        titlePanel.startButton.addActionListener(this);
        titlePanel.add(titlePanel.startButton);
        add(titlePanel);
        // draw the string (titlePanel.welcomeMsg)
        // ------------------------------------------------------------        
        // Set up optionsPanel ----------------------------------------
        optionsPanel = new OptionsPanel(gamePanel);
        optionsPanel.setVisible(false);
        optionsPanel.setLayout(null);
        optionsPanel.setBounds(0, 0, 500, 500);

        // Hero options
        // ---- Choose your hero
        optionsPanel.heroButtons.setBounds(25, 50, 165, 30);
        optionsPanel.add(optionsPanel.heroButtons);
        // -------------------------------------------------- Hero option 1
        optionsPanel.hero1.setBounds(200, 40, 50, 50);
        optionsPanel.add(optionsPanel.hero1);
        optionsPanel.hero1.addActionListener(this);
        // -------------------------------------------------- Hero option 2
        optionsPanel.hero2.setBounds(260, 40, 50, 50);
        optionsPanel.add(optionsPanel.hero2);
        optionsPanel.hero2.addActionListener(this);
        // -------------------------------------------------- Hero option 3
        optionsPanel.hero3.setBounds(320, 40, 50, 50);
        optionsPanel.add(optionsPanel.hero3);
        optionsPanel.hero3.addActionListener(this);


        // Background options
        // ---- Choose background
        optionsPanel.backgroundButtons.setBounds(25, 130, 165, 30);
        optionsPanel.add(optionsPanel.backgroundButtons);

        // ------------------------------------------------- Background option 1
        optionsPanel.background1.setBounds(200, 120, 50, 50);
        optionsPanel.add(optionsPanel.background1);
        optionsPanel.background1.addActionListener(this);

        // ------------------------------------------------- Background option 2
        optionsPanel.background2.setBounds(260, 120, 50, 50);
        optionsPanel.add(optionsPanel.background2);
        optionsPanel.background2.addActionListener(this);

        // ------------------------------------------------- Background option 3
        optionsPanel.background3.setBounds(320, 120, 50, 50);
        optionsPanel.add(optionsPanel.background3);
        optionsPanel.background3.addActionListener(this);


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
        optionsPanel.beginGameButton.setBounds(175, 300, 150, 75);
        optionsPanel.add(optionsPanel.beginGameButton);
        optionsPanel.beginGameButton.addActionListener(this);

        add(optionsPanel);
        // ------------------------------------------------------------
        // Set up game panel ------------------------------------------
        gamePanel = new GamePanel();
        add(gamePanel);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setPanelVisiblity() {
    }

    public void resetValues() 
    {
        // Re-enable coin buttons
            gamePanel.button1.setEnabled(true);
            gamePanel.button2.setEnabled(true);
            gamePanel.button3.setEnabled(true);
            gamePanel.button4.setEnabled(true);
            
            // Reset visibility of coin images
            
            
            // Move hero back to center
            gamePanel.hero.x = 225;
            gamePanel.hero.y = 175;
            
            // Move zombie back to random corner
            gamePanel.zombie.setStartingPosition();
            
            // Reassign coin locations
            
            
            
            // Reset visibility of all panels
            gamePanel.setVisible(false);
            endPanel.setVisible(false);
            optionsPanel.setVisible(false);
            titlePanel.setVisible(true);
            
            // Stop timer
            timer.stop();
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == titlePanel.startButton) {
            titlePanel.setVisible(false);
            optionsPanel.setVisible(true);
        }

        if (e.getSource() == optionsPanel.beginGameButton) {
            optionsPanel.setVisible(false);
            gamePanel.setVisible(true);
            gamePanel.setBackground(color);
            gamePanel.inputFromContainerPanel(squareColor);
            if (optionsPanel.zombieDifficultyEasy == true) {
                delay = 20;
            } else {
                delay = 15;
            }
            
            gamePanel.zombie.setStartingPosition();
            timer.start();
        }
       

        if (e.getSource() == optionsPanel.hero1) {//added to set a character number
            gamePanel.characterChoosen = 1;
        }
        if (e.getSource() == optionsPanel.hero2) {
            gamePanel.characterChoosen = 2;
        }
        if (e.getSource() == optionsPanel.hero3) {
            gamePanel.characterChoosen = 3;
        }
        
        if (e.getSource() == endPanel.restartButton)
        {
            resetValues();
        }
        

        if (e.getSource() == optionsPanel.background1) {
            color = Color.BLUE;
            squareColor = Color.blue;
        }
        if (e.getSource() == optionsPanel.background2) {
            color = Color.YELLOW;
            squareColor = Color.yellow;
        }
        if (e.getSource() == optionsPanel.background3) {
            color = Color.GREEN;
            squareColor = Color.green;

        }

        if (e.getSource() == timer) {
            gamePanel.zombie.move(gamePanel.heroCurrentX, gamePanel.heroCurrentY);
            repaint();
            if (gamePanel.button1Used == true && gamePanel.button2Used == true
                    && gamePanel.button3Used == true && gamePanel.button4Used == true || gamePanel.zombieWins == true) {//Determines if all the buttons should be pressed
                endPanel = new EndPanel();
            }
        }
    }
}
/*
 * ImageFilter filter = new GrayFilter(true, 50);  
ImageProducer producer = new FilteredImageSource(colorImage.getSource(), filter);  
Image mage = Toolkit.getDefaultToolkit().createImage(producer); 
 */
