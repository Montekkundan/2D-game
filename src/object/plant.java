package object;

import entity.Entity;
import main.GamePanel;


public class plant extends Entity {
    public plant(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/plant", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
