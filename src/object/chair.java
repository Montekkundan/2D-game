package object;

import entity.Entity;
import main.GamePanel;


public class chair extends Entity {
    public chair(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/chair", gp.tileSize, gp.tileSize);
        collision = false;
    }

}
