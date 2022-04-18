package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class Hearts extends SuperObject{
    GamePanel gp;
    public Hearts(GamePanel gp){
        this.gp = gp;
        name= "Heart";
        InputStream t_1 = getClass().getClassLoader().getResourceAsStream("res/objects/heart_full.png");
        InputStream t_2 = getClass().getClassLoader().getResourceAsStream("res/objects/heart_half.png");
        InputStream t_3 = getClass().getClassLoader().getResourceAsStream("res/objects/heart_blank.png");
        try {
            assert t_1 != null;
            image = new ImageIcon(ImageIO.read(t_1));
            assert t_2 != null;
            image2 = new ImageIcon(ImageIO.read(t_2));
            assert t_3 != null;
            image3 = new ImageIcon(ImageIO.read(t_3));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
