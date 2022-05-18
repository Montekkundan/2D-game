package object;

import entity.Entity;
import main.GamePanel;


public class toilet extends Entity {
    public toilet(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/toilet", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
