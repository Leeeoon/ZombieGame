package zombiegame;

import java.util.*;
import java.awt.Image;
import java.awt.Rectangle;

public class ImageEntity {

    Random r;
    Image image;
    Image image2;
    Image image3;
    Rectangle bounds;
    int x;
    int y;

    public ImageEntity() {
        r = new Random();
        x = r.nextInt(300);
        y = r.nextInt(300);
    }

    
}
