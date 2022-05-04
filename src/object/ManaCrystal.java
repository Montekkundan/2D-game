package object;

import entity.Entity;
import main.GamePanel;

public class ManaCrystal extends Entity {
    GamePanel gp;

    public ManaCrystal (GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_pickUpOnly;
        name = "Mana Crystal";
        value = 1;
        down1 = setup("/res/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image = setup("/res/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image2 = setup("/res/objects/manacrystal_blank", gp.tileSize, gp.tileSize);
    }
    public void use(Entity entity){
        gp.playSoundEffect(3);
        gp.ui.addMessage("Mana +" +value);
        entity.mana += value;
    }
}
