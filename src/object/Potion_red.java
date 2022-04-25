package object;

import entity.Entity;
import main.GamePanel;

public class Potion_red extends Entity {
    GamePanel gp;
    int value =5;
    public Potion_red(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Red Potion";
        type = type_consumable;
        down1 = setup("/res/objects/potion", gp.tileSize, gp.tileSize);
        description = "["+name+"]\n Heals your life by "+ value+".";
    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue ="You drank the"+name+"!\n"+"Your life has been recovered by"+value+".";
        entity.life +=value;
        if(gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
        gp.playSoundEffect(3);
    }
}
