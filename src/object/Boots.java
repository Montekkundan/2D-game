package object;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class Boots extends SuperObject{
    public Boots(){
        name= "Boots";
        InputStream t_1 = getClass().getClassLoader().getResourceAsStream("res/objects/boots.png");
        try {
            assert t_1 != null;
            image = new ImageIcon(ImageIO.read(t_1));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
