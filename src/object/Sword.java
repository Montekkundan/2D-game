package object;

import entity.Entity;
import main.GamePanel;

public class Sword extends Entity {
    public Sword(GamePanel gp) {
        super(gp);
        name = "Sword";
        down1 = setup("/res/objects/sword", gp.tileSize, gp.tileSize);
        attackValue= 1;
    }
}
