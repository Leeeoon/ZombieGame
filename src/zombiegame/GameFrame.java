package zombiegame;

import javax.swing.*;

public class GameFrame extends JFrame {
    
    ContainerPanel containerPanel;

    public GameFrame() {
        
        containerPanel = new ContainerPanel();
        JFrame application = new JFrame();
        application.setTitle("The Zombie Game");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(containerPanel);

        application.setSize(500, 500);
        application.setVisible(true);
    }
}
