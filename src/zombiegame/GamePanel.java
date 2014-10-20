package zombiegame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener {
    
    Random r;
    Hero hero;
    Zombie zombie;
    BucketPanel bucketPanel;
    Items items;
    int difficulty;
    
    final static int EASY_DIFFICULTY = 0;
    final static int HARD_DIFFICULTY = 1;
    
    int heroCurrentX;
    int heroCurrentY;
    
    int zombieCurrentX;
    int zombieCurrentY;
    
    public GamePanel() 
    {
        r = new Random();
        hero = new Hero();
        zombie = new Zombie();
        items = new Items();
        difficulty = EASY_DIFFICULTY;
        
        heroCurrentX = hero.x;
        heroCurrentY = hero.y;
        
        /*zombieCurrentX = zombie.x;
        zombieCurrentY = zombie.y;*/
        
        this.addKeyListener(this);
        this.setFocusable(true);
        
        
        
        // Layout shit - Dana 10/19
        // Layout, visible, bounds already set in containerPanel
        // Bucket shit
        bucketPanel = new BucketPanel();
        bucketPanel.setLayout(new GridLayout(1, 4));
        //Items item1
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(hero.image, heroCurrentX, heroCurrentY, 50, 50, null);
        g.drawImage(zombie.image, zombie.x, zombie.y, 50, 50, null);
    }
    
    void setPlayer()
    {
        
    }
    
    void setDifficulty()
    {
        
    }
    
    void setBackground()
    {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
           heroCurrentX++;
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
           heroCurrentX--;
    } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            heroCurrentY--;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            heroCurrentY++;
    }

    zombie.move(heroCurrentX, heroCurrentY);
    repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
