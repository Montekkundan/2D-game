package object;

import entity.Entity;
import main.GamePanel;

public class Blue_shield extends Entity {
    public Blue_shield(GamePanel gp) {
        super(gp);
        name = "Blue shield";
        type = type_shield;
        down1 = setup("/res/objects/shield_blue", gp.tileSize, gp.tileSize);
        defenceValue = 2;
        description = "["+name+"]\n A shiny blue shield.";
    }
}
