package object;

import entity.Entity;
import main.GamePanel;


public class cupboard extends Entity {
    public cupboard(GamePanel gp) {
        super(gp);
        down1 = setup("/res/objects/cupboard", gp.tileSize, gp.tileSize);
        collision = true;
    }

}
