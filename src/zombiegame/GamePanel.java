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
    Image coinImage;
    final static int EASY_DIFFICULTY = 0;
    final static int HARD_DIFFICULTY = 1;
    int heroCurrentX;
    int heroCurrentY;
    int zombieCurrentX;
    int zombieCurrentY;
    Items item1, item2, item3, item4;
    JButton button1, button2, button3, button4;
//-----------------------------------------------------------------------
                                                                     
    int characterChosen = 1;                                           //Rectangles that determine if you have touched the zombie
    Rectangle rc1, rc2, rc3, rc4;                                     
    boolean coinPicked1, coinPicked2, coinPicked3, coinPicked4;
    boolean button1Used, button2Used, button3Used, button4Used;         //Used for if the button is active or not
    boolean zombieWins;
    Color backgroundColor;
//------------------------------------------------------------------------------

    public GamePanel() { 
        r = new Random();
        hero = new Hero();
        zombie = new Zombie();
        items = new Items();
        difficulty = EASY_DIFFICULTY;                                           //For determining the difficulty

        heroCurrentX = 225;
        heroCurrentY = 175;

        this.addKeyListener(this);
        this.setFocusable(true);

        // Layout, visible, bounds already set in containerPanel
        setLayout(null);
        setBounds(0, 0, 500, 500);

        // Set up bucket panel
        bucketPanel = new BucketPanel();
        bucketPanel.setBounds(0, 400, 500, 80);
        bucketPanel.setLayout(new GridLayout(1, 4));
        item1 = new Items();
        item2 = new Items();
        item3 = new Items();
        item4 = new Items();

        coinImage = item1.image;
        coinImage = coinImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        button1 = new JButton();
        button1.setIcon(new ImageIcon(coinImage));
        button2 = new JButton();
        button2.setIcon(new ImageIcon(coinImage));
        button3 = new JButton();
        button3.setIcon(new ImageIcon(coinImage));
        button4 = new JButton();
        button4.setIcon(new ImageIcon(coinImage));

        bucketPanel.add(button1);
        bucketPanel.add(button2);
        bucketPanel.add(button3);
        bucketPanel.add(button4);
        add(bucketPanel);

    }

    public void inputFromContainerPanel(Color squareColor) {
        backgroundColor = squareColor;
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//------------------------------------------------------------------------------Painting the correct character        
        if (characterChosen == 1) {
            g.drawImage(hero.image, heroCurrentX, heroCurrentY, 50, 50, null);
        }
        if (characterChosen == 2) {
            g.drawImage(hero.image2, heroCurrentX, heroCurrentY, 50, 50, null);
        }
        if (characterChosen == 3) {
            g.drawImage(hero.image3, heroCurrentX, heroCurrentY, 50, 50, null);
        }
//------------------------------------------------------------------------------Drawing the coins
        g.drawImage(zombie.image, zombie.x, zombie.y, 50, 50, null);

        // Draw line to separate game field from bucket panel
        g.drawLine(0, 400, 500, 400);

        // Draw images on game field
        g.setColor(backgroundColor);
        
        if (coinPicked1 == true) {
            button1.setEnabled(false);    //Grays out the button
            item1.x = 5000;               // Moves the button offscreen (since we couldn't figure out a way to delete or un-draw the image)
        }
        else // coin has not been picked
        {
            g.drawImage(item1.image, item1.x, item1.y, 50, 50, null);
            rc1 = new Rectangle(item1.x, item1.y, 50, 50);
        }
        if (coinPicked2 == true) {
            
            button2.setEnabled(false); 
            item2.x = 5000;
        }
        else
        {
            g.drawImage(item2.image, item2.x, item2.y, 50, 50, null);
            rc2 = new Rectangle(item2.x, item2.y, 50, 50);
        }
        if (coinPicked3 == true) {                                 
            button3.setEnabled(false);  
            item3.x = 5000;             
        }
        else
        {
            g.drawImage(item3.image, item3.x, item3.y, 50, 50, null);
            rc3 = new Rectangle(item3.x, item3.y, 50, 50);
        }
        if (coinPicked4 == true) {
            button4.setEnabled(false); 
            item4.x = 5000;
        }
        else
        {
            g.drawImage(item4.image, item4.x, item4.y, 50, 50, null);
            rc4 = new Rectangle(item4.x, item4.y, 50, 50);
        }
        //----------------------------------------------------------------------
    }

    public void pickedUpCoin(int xH, int yH) {
        Rectangle heroCoin = new Rectangle(xH, yH, 50, 50);
        if (rc1.intersects(heroCoin)) {
            coinPicked1 = true;
            button1Used = true;
        }
        if (rc2.intersects(heroCoin)) {
            coinPicked2 = true;
            button2Used = true;
        }
        if (rc3.intersects(heroCoin)) {
            coinPicked3 = true;
            button3Used = true;
        }
        if (rc4.intersects(heroCoin)) {
            coinPicked4 = true;
            button4Used = true;
        }
    }
    
    // Check collisions between zombie and player
    public void checkCollisions(int xH, int yH) {
        Rectangle r1 = new Rectangle(xH, yH, 50, 50);
        Rectangle r2 = new Rectangle(zombie.x, zombie.y, 50, 50);
        if (r1.intersects(r2)) {
            zombieWins = true;      
        }
    }

    void setDifficulty() {
        // Not used
    }

    void setBackground() {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (heroCurrentX < 450) {
                heroCurrentX += 4;
            } else {
                heroCurrentX += 0;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (heroCurrentX > 0) {
                    heroCurrentX -= 4;
                } else {
                    heroCurrentX += 0;
                }
            } else {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (heroCurrentY > 0) {
                        heroCurrentY -= 4;
                    } else {
                        heroCurrentY += 0;
                    }
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (heroCurrentY < 350) {
                            heroCurrentY += 4;
                        } else {
                            heroCurrentY += 0;
                        }
                    }
                }
            }
        }


        checkCollisions(heroCurrentX, heroCurrentY);
        pickedUpCoin(heroCurrentX, heroCurrentY);
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Needed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Needed
    }
}