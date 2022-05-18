package object;

import entity.Entity;
import main.GamePanel;


public class table extends Entity {
    public table(GamePanel gp) {
        super(gp);
        type = type_contact;
        down1 = setup("/res/objects/table", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
