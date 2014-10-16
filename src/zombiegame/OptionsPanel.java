package zombiegame;

import javax.swing.*;
import javax.swing.JRadioButton;
//Updated: 10/15 by Graeson
public class OptionsPanel extends JPanel {

   void setValues() {
        JButton heroButtons;                          //If these are out of the setValues() method then they are considered
        JButton backgroundButton;                     //static and it won't work
        JRadioButton easy, hard;
        ButtonGroup bg;                               //What is a button group
        JButton beginGameButton;


        heroButtons = new JButton("Hero");
        backgroundButton = new JButton("Why?");       //Not sure what this is for
        add(heroButtons);
        add(backgroundButton);
//Button Group
        easy = new JRadioButton("Easy");
        hard = new JRadioButton("hard");
        bg = new ButtonGroup();
        bg.add(easy);
        bg.add(hard);
    }
}
