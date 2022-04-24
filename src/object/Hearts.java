package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class Hearts extends Entity {
    public Hearts(GamePanel gp){
        super(gp);
        name= "Heart";
        image = setup("/res/objects/heart_full");
        image2 = setup("/res/objects/heart_half");
        image3 = setup("/res/objects/heart_blank");

    }
}
