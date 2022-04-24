package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.util.Random;

public class MON_Ghost extends Entity {
    GamePanel gp;
    public MON_Ghost(GamePanel gp) {
        super(gp);
        this.gp =gp;
        type =2;
        name = "Ghost";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        solidArea.x = 1; // 8 if not tile bases movement
        solidArea.y= 1; //  16 if not tile based movement
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 46; // 32 if not tile based movement
        solidArea.height = 46; // 32 if not tile based movement
        getImage();
    }
    public void getImage(){
        up1 = setup("/res/monster/ghost/tile009", gp.tileSize, gp.tileSize);
        up2 = setup("/res/monster/ghost/tile011", gp.tileSize, gp.tileSize);
        down1 = setup("/res/monster/ghost/tile000", gp.tileSize, gp.tileSize);
        down2 = setup("/res/monster/ghost/tile002", gp.tileSize, gp.tileSize);
        left1 = setup("/res/monster/ghost/tile003", gp.tileSize, gp.tileSize);
        left2 = setup("/res/monster/ghost/tile005", gp.tileSize, gp.tileSize);
        right1 = setup("/res/monster/ghost/tile006", gp.tileSize, gp.tileSize);
        right2 = setup("/res/monster/ghost/tile008", gp.tileSize, gp.tileSize);
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
}
