package object;

import entity.Entity;
import main.GamePanel;

public class Wooden_shield extends Entity {
    public Wooden_shield(GamePanel gp) {
        super(gp);
        name = "Wood shield";
        type = type_shield;
        down1 = setup("/res/objects/shield_wood", gp.tileSize, gp.tileSize);
        defenceValue = 1;
        description = "["+name+"]\n An old wooden shield.";
    }
}
