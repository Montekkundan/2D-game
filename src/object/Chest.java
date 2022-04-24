package object;

import entity.Entity;
import main.GamePanel;


public class Chest extends Entity {
    public Chest(GamePanel gp) {
        super(gp);
        down1 = setup("/res/objects/chest");
    }

}



