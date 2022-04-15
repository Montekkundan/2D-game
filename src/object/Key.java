package object;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class Key extends SuperObject{
    public Key(){
        name= "Key";
        InputStream t_1 = getClass().getClassLoader().getResourceAsStream("res/objects/key.png");
        try {
            assert t_1 != null;
            image = new ImageIcon(ImageIO.read(t_1));
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
