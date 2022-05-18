package object;

import entity.Entity;
import main.GamePanel;


public class bed extends Entity {
    public bed(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/bed", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
