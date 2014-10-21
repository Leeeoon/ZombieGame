package zombiegame;

import javax.swing.*;

public class EndPanel extends JPanel {

    JButton exitButton;
    JButton restartButton;

    public EndPanel() {
        exitButton = new JButton("EXIT");                            //Creating the buttons
        restartButton = new JButton("Restart");                      //They aren't being used right now
        
        JPanel myPanel = new JPanel();
        //myPanel.add(exitButton);                                   //These can be added if needed
        // myPanel.add(restartButton);
//-------------------------------------------------------------------Renaming the preset "ok" and "cancel" buttons
        UIManager.put("OptionPane.cancelButtonText", "EXIT GAME");
        UIManager.put("OptionPane.okButtonText", "RESTART"); 
        myPanel.add(new JLabel("Do You Want to Restart?"));
//-------------------------------------------------------------------Displays the JOptionPane's parts
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "GAME OVER", JOptionPane.OK_CANCEL_OPTION);
//-------------------------------------------------------------------        
        if (result == JOptionPane.CANCEL_OPTION) {                   //This exits the game when it is over
            System.exit(0);
        }
        if (result == JOptionPane.OK_OPTION) {                       //Sends the user back to te TitlePanel
            
        }

    }
}
