package zombiegame;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//Updated: 10/15 by Graeson
//Need to find out the visibility for it

public class OptionsPanel extends JPanel implements ActionListener, ItemListener {

    JButton heroButtons;                          //If these are out of the setValues() method then they are considered
    JButton backgroundButtons;                     //static and it won't work
    JRadioButton easy, hard;
    ButtonGroup difficulty; // Renamed from "bg" to "difficulty" to avoid confusion
    JButton beginGameButton;
    JButton difficultyButtons;
    // int characterChoosen;                              //Created for matching the characters
    String whoIsHero;
    int whatIsDifficulty;
    String whatIsBackground;
    // Adding separate buttons for the hero/background images - Dana
    JButton hero1; // will add more later
    JButton hero2;
    JButton hero3;
    JButton background1; // will add more later
    JButton background2;
    JButton background3;
    GamePanel gamePanel;
    boolean zombieDifficultyEasy;
    
    Image crazyDave;
    Image peashooter;
    Image frostPeashooter;

    public OptionsPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        try {                
          crazyDave = ImageIO.read(new File("Crazy Dave.png"));
          peashooter = ImageIO.read(new File("peashooter2.png"));
          frostPeashooter = ImageIO.read(new File("Ice Plant.png"));
       } catch (IOException e) {
       
       }
        crazyDave = crazyDave.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        peashooter = peashooter.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        frostPeashooter = frostPeashooter.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        beginGameButton = new JButton("Begin Game");
        heroButtons = new JButton("Choose your hero:");
        hero1 = new JButton();
        hero2 = new JButton();
        hero3 = new JButton();
        hero1.setIcon(new ImageIcon(crazyDave));
        hero2.setIcon(new ImageIcon(peashooter));
        hero3.setIcon(new ImageIcon(frostPeashooter));
        background1 = new JButton("Blue");
        background2 = new JButton("Yellow");
        background3 = new JButton("Green");
        backgroundButtons = new JButton("Choose background:");       //Not sure what this is for
//---------------------------------------------------Button Group
        difficultyButtons = new JButton("Choose difficulty:");
        easy = new JRadioButton("Easy");
        hard = new JRadioButton("Hard");
        difficulty = new ButtonGroup();
        difficulty.add(easy);
        difficulty.add(hard);
        easy.setSelected(true);
        
//---------------------------------------------------Adding the buttons        
        //add(heroButtons);
        //add(backgroundButtons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == hero1) {
            whoIsHero = "Crazy Dave";
        }
        if (e.getSource() == hero2) {
            whoIsHero = "Pea Shooter";
        }
        if (e.getSource() == hero3) {
            whoIsHero = "Ice Plant";
        }
        if (e.getSource() == easy) {
            easy.setSelected(true);
            hard.setSelected(false);
            zombieDifficultyEasy = true;
        }
        if (e.getSource() == hard) {
            easy.setSelected(false);
            hard.setSelected(true);
            zombieDifficultyEasy = false;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == easy && e.getStateChange() == ItemEvent.SELECTED) {
            whatIsDifficulty = 0;
        }
        if (e.getSource() == hard && e.getStateChange() == ItemEvent.SELECTED) {
            whatIsDifficulty = 1;
        }
    }

    void setValues() {
    }
}
