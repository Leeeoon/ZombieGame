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
    
    public void move() // may change to protected
    {
        
        
    }
    
    
}
