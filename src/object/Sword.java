package object;

import entity.Entity;
import main.GamePanel;

public class Sword extends Entity {
    public Sword(GamePanel gp) {
        super(gp);
        name = "Sword";
        type = type_sword;
        down1 = setup("/res/objects/sword", gp.tileSize, gp.tileSize);
        attackValue= 1;
        attackArea.width =36;
        attackArea.height = 36;
        description = "["+name+"]\n An old sword.";
    }
}
