package object;

import entity.Entity;
import main.GamePanel;

public class Potion_red extends Entity {
    GamePanel gp;

    public Potion_red(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Red Potion";
        value =5;
        type = type_consumable;
        down1 = setup("/res/objects/potion", gp.tileSize, gp.tileSize);
        description = "["+name+"]\n Heals your life by "+ value+".";
    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue ="You drank the"+name+"!\n"+"Your life has been recovered by"+value+".";
        entity.life +=value;
        gp.playSoundEffect(3);
    }
}
