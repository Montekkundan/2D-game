package object;

import entity.Entity;
import main.GamePanel;


public class Boots extends Entity {
    public Boots(GamePanel gp) {
        super(gp);
        down1 = setup("/res/objects/boots");
    }

}



