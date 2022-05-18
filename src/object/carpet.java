package object;

import entity.Entity;
import main.GamePanel;


public class carpet extends Entity {
    public carpet(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/carpet", gp.tileSize, gp.tileSize);
        collision = false;
    }

}
