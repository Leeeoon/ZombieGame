package zombiegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EndPanel extends JPanel implements ActionListener {

    JButton exitButton;
    JButton restartButton;

    public EndPanel() {

        setLayout(null);

        exitButton = new JButton("EXIT");
        restartButton = new JButton("RESTART");

        restartButton.setBounds(175, 150, 100, 50);
        exitButton.setBounds(175, 250, 100, 50);

        exitButton.addActionListener(this);
        restartButton.addActionListener(this);

        add(exitButton);
        add(restartButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}

