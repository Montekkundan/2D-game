package object;

import entity.Entity;
import main.GamePanel;


public class bookcase extends Entity {
    public bookcase(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/bookcase", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
