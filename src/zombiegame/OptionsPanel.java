package zombiegame;

import javax.swing.*;
//Updated: 10/15 by Graeson
//Need to find out the visibility for it
public class OptionsPanel extends JPanel {

    JButton heroButtons;                          //If these are out of the setValues() method then they are considered
    JButton backgroundButton;                     //static and it won't work
    JRadioButton easy, hard;
    ButtonGroup bg;
    JButton beginGameButton;

    public OptionsPanel(GamePanel gamePanel) {
        beginGameButton = new JButton("Begin Game");
        heroButtons = new JButton("Hero");
        backgroundButton = new JButton("Background Button");       //Not sure what this is for

//---------------------------------------------------Button Group
        easy = new JRadioButton("Easy");
        hard = new JRadioButton("hard");
        bg = new ButtonGroup();
//---------------------------------------------------Adding the buttons        
        add(heroButtons);
        add(backgroundButton);
        bg.add(easy);
        bg.add(hard);


    }

    void setValues() {
    }
}
