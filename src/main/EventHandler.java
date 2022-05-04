package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    EventRect eventRectangle[][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    public EventHandler(GamePanel gp){
        this.gp=gp;
        eventRectangle = new EventRect[gp.maxWorldColumn][gp.maxWorldRow];
        int col = 0;
        int row = 0;
        while(col<gp.maxWorldColumn && row<gp.maxWorldRow) {
            eventRectangle[col][row] = new EventRect();
            eventRectangle[col][row].x = 23;
            eventRectangle[col][row].y = 23;
            eventRectangle[col][row].width = 2;
            eventRectangle[col][row].height = 2;
            eventRectangle[col][row].eventRectDefaultX = eventRectangle[col][row].x;
            eventRectangle[col][row].eventRectDefaultY = eventRectangle[col][row].y;
            col++;
            if(col==gp.maxWorldColumn){
                col=0;
                row++;
            }
        }
    }
    public void checkEvent(){
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance> gp.tileSize){
            canTouchEvent = true;
        }
        if(canTouchEvent == true) {
            if (hit(27, 16, "right")) {
                damagePit(27, 16, gp.dialogueState);
            }
            if (hit(23, 7, "down")) {
                healingPool(23, 7, gp.dialogueState);
            }
            if (hit(23, 12, "up")) {
                teleport(23, 12, gp.dialogueState);
            }
            if (hit(38, 10, "up")) {
                teleportBack(38, 10, gp.dialogueState);
            }
        }
    }

    public void damagePit(int col, int row,int gameState) {

        gp.gameState = gameState;
        gp.playSoundEffect(6);
        gp.ui.currentDialogue = "You fell into a pit!";
        gp.player.life -= 1;
        canTouchEvent = false; // one time damage on player arrival
    }
    public void healingPool(int col, int row,int gameState){
        if(gp.keyH.spacePressed == true) {
            gp.playSoundEffect(3);
            gp.player.attackCanceled = true;
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You drank water. \nYour life and mana have been restored.";
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            gp.aSetter.setMonster();
        }

    }
    public void teleport(int col, int row,int gameState){
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Teleport!";
            gp.player.worldX = gp.tileSize *37;
            gp.player.worldY = gp.tileSize *10;
    }
    public void teleportBack(int col, int row,int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Teleport!";
        gp.player.worldX = gp.tileSize *23;
        gp.player.worldY = gp.tileSize *23;
    }

    public boolean hit(int col, int row, String reqDirection){
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRectangle[col][row].x = col*gp.tileSize +eventRectangle[col][row].x;
        eventRectangle[col][row].y = row*gp.tileSize +eventRectangle[col][row].y;
        if(gp.player.solidArea.intersects(eventRectangle[col][row]) && eventRectangle[col][row].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRectangle[col][row].x = eventRectangle[col][row].eventRectDefaultX;
        eventRectangle[col][row].y = eventRectangle[col][row].eventRectDefaultY;

        return hit;

    }
}
