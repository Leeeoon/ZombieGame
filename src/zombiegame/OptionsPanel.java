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

    public OptionsPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        beginGameButton = new JButton("Begin Game");
        heroButtons = new JButton("Choose your hero:");
        hero1 = new JButton("1");
        hero2 = new JButton("2");
        background1 = new JButton("1");
        backgroundButtons = new JButton("Choose background:");       //Not sure what this is for
//---------------------------------------------------Button Group
        difficultyButtons = new JButton("Choose difficulty:");
        easy = new JRadioButton("Easy");
        hard = new JRadioButton("Hard");
        /*difficulty = new ButtonGroup();
         difficulty.add(easy);
         difficulty.add(hard);*/
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
            whoIsHero = "Peashooter";
        }
        if (e.getSource() == hero3) {
            whoIsHero = "Sunflower";
        }
        if (e.getSource() == background1) {
            whatIsBackground = "grass";
        }
        if (e.getSource() == background2) {
            whatIsBackground = "night grass";
        }
        if (e.getSource() == background3) {
            whatIsBackground = "lava";
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
