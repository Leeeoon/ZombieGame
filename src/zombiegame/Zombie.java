package zombiegame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Zombie extends ImageEntity 
{
    public Zombie()
    {
       try {                
          image = ImageIO.read(new File("Zombie.png"));
       } catch (IOException e) {
       
       }
    }
    
    public void move(int heroX, int heroY) // may change to protected
    {
        int moveX = 0;
        int moveY = 0;
        
        if (this.x - heroX < 0) // hero is to the right
        {
            moveX = 1;
        }
        else if (this.x - heroX > 0) // hero is to the left
        {
            moveX = -1;
        }
        else // hero is directly above or below zombie
        {
            moveX = 0;
        }
        
        if (this.y - heroY < 0) // hero is below zombie
        {
            moveY = 1;
        }
        else if (this.y - heroY > 0) // hero is above zombie
        {
            moveY = -1;
        }
        else // hero is directly to the right or left of zombie
        {
            moveY = 0;
        }
        
        this.x += moveX;
        this.y += moveY;
        
    }
    
    
}
