package entity;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Entity {
    GamePanel gp;
    public ImageIcon up1, up2, down1, down2, left1, left2, right1, right2, stand;
    public ImageIcon attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int solidAreaDefaultX , solidAreaDefaultY;
    public int invincibleCounter = 0;
    String dialogues[] = new String[20];
    public ImageIcon image, image2, image3;
    public String name;


    //State
    public int worldX, worldY;
    public String direction = "down";
    public int spriteNum = 1;
    int dialogueIndex = 0;
    public boolean collision = false;
    public boolean invincible = false;
    boolean attacking = false;

    //Counter
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    public int spriteCounter = 0;

    //Character Status
    public int maxLife;
    public int life;
    public int type; // 0 - player, 1-npc, 2- monster
    public int speed;

    public Entity(GamePanel gp){
        this.gp =gp;
    }
    public void setAction(){

    }
    public void speak(){
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
        switch (gp.player.direction){
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }
    public void update(){
        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this,gp.npc);
        gp.cChecker.checkEntity(this,gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type ==2 && contactPlayer == true){
            if(gp.player.invincible == false){
                gp.player.life -=1;
                gp.player.invincible = true;
            }
        }
        // If collision is false, npc can move.
        if(collisionOn == false){
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }

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
    public void draw(Graphics2D g2){
        ImageIcon image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
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
            //Monster Hp bar
            if(type ==2) {
                g2.setColor(new Color(35, 35, 35));
                g2.fillRect(screenX-1, screenY-16, gp.tileSize+2, 12);
                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY-15, gp.tileSize, 10);
            }
            assert image != null;
            g2.drawImage(image.getImage(), screenX , screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}