package object;

import entity.Entity;
import main.GamePanel;


public class Door extends Entity {
    public Door(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/door", gp.tileSize, gp.tileSize);
        collision = true;
    }

}



