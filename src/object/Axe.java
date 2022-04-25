package object;

import entity.Entity;
import main.GamePanel;

public class Axe extends Entity {
    public Axe(GamePanel gp) {
        super(gp);
        name = "Woodcutter's Axe";
        type = type_axe;
        down1 = setup("/res/objects/Axe", gp.tileSize, gp.tileSize);
        attackValue= 2;
        attackArea.width =30;
        attackArea.height = 30;
        description = "["+name+"]\n A rusty axe used \nto cut trees.";
    }
}
