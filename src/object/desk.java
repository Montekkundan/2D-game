package object;

import entity.Entity;
import main.GamePanel;


public class desk extends Entity {
    public desk(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/desk", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
