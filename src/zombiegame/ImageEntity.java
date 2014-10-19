package zombiegame;

import java.util.*;
import java.awt.Image;
import java.awt.Rectangle;

public class ImageEntity 
{
    Random r;
    Image image;
    Rectangle bounds;
    int x;
    int y;
    
    
    public ImageEntity()
    {
        r = new Random();
        x = r.nextInt(450);
        y = r.nextInt(450);
    }
    
    public void checkCollisions()
    {
        
    }
    
}
