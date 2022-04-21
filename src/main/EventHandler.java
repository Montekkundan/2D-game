package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRectangle;
    int eventRectDefaultX, eventRectDefaultY;
    public EventHandler(GamePanel gp){
        this.gp=gp;
        eventRectangle = new Rectangle();
        eventRectangle.x = 23;
        eventRectangle.y = 23;
        eventRectangle.width = 2;
        eventRectangle.height =2;
        eventRectDefaultX = eventRectangle.x;
        eventRectDefaultY = eventRectangle.y;
    }
    public void checkEvent(){
        if(hit(27,16,"right")){
            damagePit(gp.dialogueState);
        }
        if(hit(23,7,"down")){
            healingPool(gp.dialogueState);
        }
        if(hit(23,12,"up")){
            teleport(gp.dialogueState);
        }
        if(hit(38,10,"up")){
            teleportBack(gp.dialogueState);
        }
    }

    public void damagePit(int gameState) {

        gp.gameState = gameState;
        gp.ui.currentDialogue = "You fell into a pit!";
        gp.player.life -= 1;
    }
    public void healingPool(int gameState){
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You drank water. \nYou are now healed.";
            gp.player.life = gp.player.maxLife;

    }
    public void teleport(int gameState){
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Teleport!";
            gp.player.worldX = gp.tileSize *37;
            gp.player.worldY = gp.tileSize *10;
    }
    public void teleportBack(int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Teleport!";
        gp.player.worldX = gp.tileSize *23;
        gp.player.worldY = gp.tileSize *23;
    }

    public boolean hit(int eventColumn, int eventRow, String reqDirection){
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRectangle.x = eventColumn*gp.tileSize +eventRectangle.x;
        eventRectangle.y = eventRow*gp.tileSize +eventRectangle.y;
        if(gp.player.solidArea.intersects(eventRectangle)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRectangle.x = eventRectDefaultX;
        eventRectangle.y = eventRectDefaultY;

        return hit;

    }
}
