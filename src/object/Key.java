package object;

import entity.Entity;
import main.GamePanel;


public class Key extends Entity {
    public Key(GamePanel gp) {
            super(gp);
            name = "Key";
            down1 = setup("/res/objects/key", gp.tileSize, gp.tileSize);
            description = "["+name+"]\n It opens a door";
        }
    }

