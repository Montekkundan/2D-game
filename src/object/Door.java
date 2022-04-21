package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class Door extends Entity {
    public Door(GamePanel gp){
        super(gp);
        name= "Door";
        InputStream t_1 = getClass().getClassLoader().getResourceAsStream("res/objects/door.png");
        try {
            assert t_1 != null;
            image = new ImageIcon(ImageIO.read(t_1));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height= 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
