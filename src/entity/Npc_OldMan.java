package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.util.Random;

public class Npc_OldMan extends Entity{

    public Npc_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed =1;
        getNpcImage();
        setDialogue();
    }
    public void getNpcImage() {
        up1 = setup("/res/npc/tile009", gp.tileSize, gp.tileSize);
        up2 = setup("/res/npc/tile011", gp.tileSize, gp.tileSize);
        down1 = setup("/res/npc/tile000", gp.tileSize, gp.tileSize);
        down2 = setup("/res/npc/tile002", gp.tileSize, gp.tileSize);
        left1 = setup("/res/npc/tile003", gp.tileSize, gp.tileSize);
        left2 = setup("/res/npc/tile005", gp.tileSize, gp.tileSize);
        right1 = setup("/res/npc/tile006", gp.tileSize, gp.tileSize);
        right2 = setup("/res/npc/tile008", gp.tileSize, gp.tileSize);
    }
    public void setAction() {
        actionLockCounter++;
        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
    public void setDialogue(){
        dialogues[0]="Hello, young adventurer!";
        dialogues[1]="So you are here to find \nthe lost treasure of this island?!";
        dialogues[2]="*Sigh* I too was an adventurer \nlike you... but now I'm lost \nin this island.";
        dialogues[3]="Well I  hope you find the treasure!";

    }
    public void speak(){
        super.speak();
    }
}
