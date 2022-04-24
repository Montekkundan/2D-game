package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.Sword;
import object.Wooden_shield;

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
    public boolean attackCanceled = false;
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

        attackArea.width = 36;
        attackArea.height = 36;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }
    public void setDefaultValues(){
        worldX= gp.tileSize * 23;
        worldY= gp.tileSize * 21 ;
        speed =4;
        direction = "down";
        maxLife = 6;
        life = maxLife;
        level = 1;
        strength =1;
        dexterity =1;
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        currentWeapon = new Sword(gp);
        currentShield = new Wooden_shield(gp);
        attack = getAttack();
        defence = getDefence();
    }
    public int getAttack(){
        return attack = strength * currentWeapon.attackValue;
    }
    public int getDefence(){
        return defence = dexterity * currentShield.defenceValue;
    }
    public void getPlayerImage() {
        if(playerSelector == 0) {
            stand = setup("/res/player/boy_down_1", gp.tileSize, gp.tileSize);
            up1 = setup("/res/player/boy_up_1", gp.tileSize, gp.tileSize);
            up2 = setup("/res/player/boy_up_2", gp.tileSize, gp.tileSize);
            down1 = setup("/res/player/boy_down_1", gp.tileSize, gp.tileSize);
            down2 = setup("/res/player/boy_down_2", gp.tileSize, gp.tileSize);
            left1 = setup("/res/player/boy_left_1", gp.tileSize, gp.tileSize);
            left2 = setup("/res/player/boy_left_2", gp.tileSize, gp.tileSize);
            right1 = setup("/res/player/boy_right_1", gp.tileSize, gp.tileSize);
            right2 = setup("/res/player/boy_right_2", gp.tileSize, gp.tileSize);
        }

    }
    public void getPlayerAttackImage(){
        attackUp1 = setup("/res/player/boy_attack_up_1", gp.tileSize, gp.tileSize*2);
        attackUp2 = setup("/res/player/boy_attack_up_2", gp.tileSize, gp.tileSize*2);
        attackDown1 = setup("/res/player/boy_attack_down_1", gp.tileSize, gp.tileSize*2);
        attackDown2 = setup("/res/player/boy_attack_down_2", gp.tileSize, gp.tileSize*2);
        attackLeft1 = setup("/res/player/boy_attack_left_1", gp.tileSize*2, gp.tileSize);
        attackLeft2 = setup("/res/player/boy_attack_left_2", gp.tileSize*2, gp.tileSize);
        attackRight1 = setup("/res/player/boy_attack_right_1", gp.tileSize*2, gp.tileSize);
        attackRight2 = setup("/res/player/boy_attack_right_2", gp.tileSize*2, gp.tileSize);
    }
    public void update(){
        if(attacking == true){
            attacking();
        }
        else if(keyH.upPressed == true || keyH.downPressed == true|| keyH.leftPressed == true|| keyH.rightPressed == true || keyH.spacePressed == true){
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


            if(gp.keyH.spacePressed == true && attackCanceled == false){
                gp.playSoundEffect(7);
                attacking = true;
                spriteCounter = 0;
            }
            attackCanceled = false;

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
    public void attacking(){
        spriteCounter++;
        if(spriteCounter <= 5){
            spriteNum =1;
        }
        if(spriteCounter >5 && spriteCounter <= 25){
            spriteNum =2;

            // save current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY =  worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //Adjust player's worldX/Y for attackArea
            switch(direction){
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;
            }
            // attackArea becomes solidArea
            solidArea.width = attackArea.width;
            solidArea.height =attackArea.height;
            // check monster collision
            int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);
            damageMonster(monsterIndex);
            // after checking collision restore default values
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;


        }
        if(spriteCounter >25){
            spriteNum =1;
            spriteCounter =0;
            attacking =false;
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
        if(gp.keyH.spacePressed == true) {
            if (i != 999) {
                attackCanceled = true;
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }

        }

//        gp.keyH.spacePressed = false;
    }
    public void contactMonster(int i){
        if(i !=999){
            if(invincible == false) {
                gp.playSoundEffect(6);
                int damage = gp.monster[i].attack - defence;
                if(damage < 0){
                    damage = 0;
                }
                life -= damage;
                invincible = true;
            }
        }
    }
    public void damageMonster(int i){
        if(i != 999){
            if(gp.monster[i].invincible == false){
                gp.playSoundEffect(5);
                int damage = attack - gp.monster[i].defence;
                if(damage < 0){
                    damage = 0;
                }
                gp.monster[i].life -= damage;
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();
                if(gp.monster[i].life <= 0){
                    gp.monster[i].dying = true;
                }
            }
        }
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y,gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        switch (direction) {
            case "up" -> {
                if(attacking == false) {
                    if (spriteNum == 1) {image = up1;}
                    if (spriteNum == 2) {image = up2;}
                }
                if(attacking == true){
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNum == 1) {image = attackUp1;}
                    if (spriteNum == 2) {image = attackUp2;}
                }
            }
            case "down" -> {
                if(attacking == false) {
                    if (spriteNum == 1) {image = down1;}
                    if (spriteNum == 2) {image = down2;}
                }
                if(attacking == true){
                    if (spriteNum == 1) {image = attackDown1;}
                    if (spriteNum == 2) {image = attackDown2;}
                }
            }
            case "left" -> {
                if(attacking == false) {
                    if (spriteNum == 1) {image = left1;}
                    if (spriteNum == 2) {image = left2;}
                }
                if(attacking == true){
                    tempScreenX = screenX -gp.tileSize;
                    if (spriteNum == 1) {image = attackLeft1;}
                    if (spriteNum == 2) {image = attackLeft2;}
                }
            }
            case "right" -> {
                if(attacking == false) {
                    if (spriteNum == 1) {image = right1;}
                    if (spriteNum == 2) {image = right2;}
                }
                if(attacking == true){
                    if (spriteNum == 1) {image = attackRight1;}
                    if (spriteNum == 2) {image = attackRight2;}
                }
            }
        }
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        g2.drawImage(image, tempScreenX , tempScreenY,null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // detection collision area, red rectangle on player
//        g2.setColor(Color.red);
//        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}