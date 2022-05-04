package object;

import entity.Entity;
import main.GamePanel;

public class Coin extends Entity {
    GamePanel gp;
    public Coin(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Coin";
        value = 1;
        type = type_pickUpOnly;
        down1 = setup("/res/objects/coin", gp.tileSize, gp.tileSize);
    }
    public void use(Entity entity){
        gp.playSoundEffect(1);
        gp.ui.addMessage("Coin +" +value);
        gp.player.coin += value;
    }
}
