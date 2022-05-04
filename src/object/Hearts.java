package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

public class Hearts extends Entity {
    GamePanel gp;
    public Hearts(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = type_pickUpOnly;
        name= "Heart";
        value =2;
        down1 =  setup("/res/objects/heart_full", gp.tileSize, gp.tileSize);
        image = setup("/res/objects/heart_full", gp.tileSize, gp.tileSize);
        image2 = setup("/res/objects/heart_half", gp.tileSize, gp.tileSize);
        image3 = setup("/res/objects/heart_blank", gp.tileSize, gp.tileSize);
    }
    public void use(Entity entity){
        gp.playSoundEffect(3);
        gp.ui.addMessage("Life +" +value);
        entity.life += value;
    }
}
