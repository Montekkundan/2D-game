package object;

import entity.Entity;
import main.GamePanel;


public class Door extends Entity {
    public Door(GamePanel gp) {
        super(gp);
        down1 = setup("/res/objects/door");
        collision = true;
    }

}



