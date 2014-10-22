package zombiegame;

import javax.swing.*;
import java.awt.event.*;
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

    public OptionsPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        beginGameButton = new JButton("Begin Game");
        heroButtons = new JButton("Choose your hero:");
        hero1 = new JButton("1");
        hero2 = new JButton("2");
        hero3 = new JButton("3");
        background1 = new JButton("1");
        background2 = new JButton("2");
        background3 = new JButton("3");
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
