package zombiegame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Items extends ImageEntity 
{
    public Items()
    {
       try {                
          image = ImageIO.read(new File("Gold Coin.png"));
       } catch (IOException e) {
       
       }    
    }
    
    
    
}
