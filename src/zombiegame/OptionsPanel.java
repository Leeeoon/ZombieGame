package zombiegame;

import javax.swing.*;
//Updated: 10/15 by Graeson
//Need to find out the visibility for it
public class OptionsPanel extends JPanel {

    JButton heroButtons;                          //If these are out of the setValues() method then they are considered
    JButton backgroundButtons;                     //static and it won't work
    JRadioButton easy, hard;
    ButtonGroup difficulty; // Renamed from "bg" to "difficulty" to avoid confusion
    JButton beginGameButton;
    JButton difficultyButtons;
    
    // Adding separate buttons for the hero/background images - Dana
    JButton hero1; // will add more later
    JButton background1; // will add more later

    public OptionsPanel(GamePanel gamePanel) {
        beginGameButton = new JButton("Begin Game");
        heroButtons = new JButton("Choose your hero:");
        hero1 = new JButton("1");
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

    void setValues() {
    }
}
