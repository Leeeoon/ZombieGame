package zombiegame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hero extends ImageEntity 
{
    public Hero()
    {
       try {                
          image = ImageIO.read(new File("Crazy Dave.png"));
       } catch (IOException e) {
       
       }
    }
    
    public void move()
    {
        
    }
    
    
}
