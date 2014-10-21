package zombiegame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener
{

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

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(hero.image, heroCurrentX, heroCurrentY, 50, 50, null);
        g.drawImage(zombie.image, zombie.x, zombie.y, 50, 50, null);

        // Draw line to separate game field from bucket panel
        g.drawLine(0, 400, 500, 400);

        // Draw images on game field
        g.drawImage(item1.image, item1.x, item1.y, 50, 50, null);
        g.drawImage(item2.image, item2.x, item2.y, 50, 50, null);
        g.drawImage(item3.image, item3.x, item3.y, 50, 50, null);
        g.drawImage(item4.image, item4.x, item4.y, 50, 50, null);
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
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if (heroCurrentX < 450)
            {
                heroCurrentX += 4;
            } else
            {
                heroCurrentX += 0;
            }
        } else
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if (heroCurrentX > 0)
                {
                    heroCurrentX -= 4;
                } else
                {
                    heroCurrentX += 0;
                }
            } else
            {
                if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    if (heroCurrentY > 0)
                    {
                        heroCurrentY -= 4;
                    } else
                    {
                        heroCurrentY += 0;
                    }
                } else
                {
                    if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    {
                        if (heroCurrentY < 350)
                        {
                            heroCurrentY += 4;
                        } else
                        {
                            heroCurrentY += 0;
                        }
                    }
                }
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

}
