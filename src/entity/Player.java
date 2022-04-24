package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
//    public int hasKeys = 0;
    public int playerSelector;
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y= 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX= gp.tileSize * 23;
        worldY= gp.tileSize * 21 ;
        speed =4;
        direction = "down";
        maxLife = 6;
        life = maxLife;
    }
    public void getPlayerImage() {
        if(playerSelector == 0) {
            stand = setup("/res/player/boy_down_1");
            up1 = setup("/res/player/boy_up_1");
            up2 = setup("/res/player/boy_up_2");
            down1 = setup("/res/player/boy_down_1");
            down2 = setup("/res/player/boy_down_2");
            left1 = setup("/res/player/boy_left_1");
            left2 = setup("/res/player/boy_left_2");
            right1 = setup("/res/player/boy_right_1");
            right2 = setup("/res/player/boy_right_2");
        }

    }
    public void getPlayerAttackImage(){
        try {
            stand = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_down_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_attack_right_2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.spacePressed == true){
            if(keyH.upPressed){
                direction = "up";

            }
            else if(keyH.downPressed){
                direction = "down";

            }
            else if(keyH.leftPressed){
                direction = "left";

            }
            else if(keyH.rightPressed){
                direction = "right";

            }
            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // check object collision
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);

            // check npc collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNpc(npcIndex);

            // check monster collision
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            //check event
            gp.eHandler.checkEvent();

            // If collision is false, player can move.
            if(collisionOn == false && keyH.spacePressed == false){
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }
            gp.keyH.spacePressed = false;
            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        if (invincible == true) {
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void pickUpObject(int i){
        if(i != 999){
            /*
            String objectName = gp.obj[i].name;
            switch (objectName){
                case "Key":
                    gp.playSoundEffect(1);
                    hasKeys++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You picked a Key!");
//                    System.out.println("keys :" +hasKeys);
                    break;
                case "Door":
                    if(hasKeys >0){
                        gp.playSoundEffect(4);
                        gp.obj[i] = null;
                        hasKeys--;
                        gp.ui.showMessage("You opened the door!");
                    }
                    else{
                        gp.ui.showMessage("You need a Key!");
                    }
//                    System.out.println("keys :" +hasKeys);
                    break;
                case "Boots":
                    gp.playSoundEffect(3);
                    speed += 2;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed Up!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSoundEffect(2);
                    break;
            }

             */
        }
    }
    public void interactNpc(int i){
        if(i != 999) {

            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();
        }
        else{
            if(keyH.spacePressed == true){
                attacking = true;
            }
        }

//        gp.keyH.spacePressed = false;
    }
    public void contactMonster(int i){
        if(i !=999){
            if(invincible == false) {
                life -= 1;
                invincible = true;
            }
        }
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y,gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
            }
        }
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, screenX , screenY,null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // detection collision area, red rectangle on player
//        g2.setColor(Color.red);
//        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}