package main;

public class EventHandler {
    GamePanel gp;
    EventRect eventRectangle[][][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    public EventHandler(GamePanel gp){
        this.gp=gp;
        eventRectangle = new EventRect[gp.maxMap][gp.maxWorldColumn][gp.maxWorldRow];
        int map =0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col<gp.maxWorldColumn && row<gp.maxWorldRow) {
            eventRectangle[map][col][row] = new EventRect();
            eventRectangle[map][col][row].x = 23;
            eventRectangle[map][col][row].y = 23;
            eventRectangle[map][col][row].width = 2;
            eventRectangle[map][col][row].height = 2;
            eventRectangle[map][col][row].eventRectDefaultX = eventRectangle[map][col][row].x;
            eventRectangle[map][col][row].eventRectDefaultY = eventRectangle[map][col][row].y;
            col++;
            if(col==gp.maxWorldColumn){
                col=0;
                row++;
                if(row == gp.maxWorldRow){
                    row = 0;
                    map++;
                }
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
            if (hit(0,27, 16, "right")) {
                damagePit(gp.dialogueState);
            }
            else if (hit(0,23, 12, "up")) {
                healingPool( gp.dialogueState);
            }
            else if (hit(0,23, 7, "down")) {
                teleport( gp.dialogueState);
            }
            else if (hit(0,38, 10, "up")) {
                teleportBack(gp.dialogueState);
            }
            else if (hit(0,10, 12, "any")) {
                map1(1,13,12,gp.dialogueState);
            }
            else if (hit(1,13, 12, "any")) {
                map0(0,10,12,gp.dialogueState);
            }
        }
    }

    public void damagePit(int gameState) {

        gp.gameState = gameState;
        gp.playSoundEffect(6);
        gp.ui.currentDialogue = "You fell into a pit!";
        gp.player.life -= 1;
        canTouchEvent = false; // one time damage on player arrival
    }
    public void healingPool(int gameState){
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
    public void map1(int map,int col, int row,int gameState){
        gp.gameState = gameState;
        gp.currentMap = map;
        gp.ui.currentDialogue = "You entered your home!";
        gp.player.worldX = gp.tileSize *col;
        gp.player.worldY = gp.tileSize *row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
    }
    public void map0(int map,int col, int row,int gameState){
        gp.gameState = gameState;
        gp.currentMap = map;
        gp.ui.currentDialogue = "You entered Village!";
        gp.player.worldX = gp.tileSize *col;
        gp.player.worldY = gp.tileSize *row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
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

    public boolean hit(int map, int col, int row, String reqDirection){
        boolean hit = false;

        if(map == gp.currentMap) {
            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRectangle[map][col][row].x = col * gp.tileSize + eventRectangle[map][col][row].x;
            eventRectangle[map][col][row].y = row * gp.tileSize + eventRectangle[map][col][row].y;
            if (gp.player.solidArea.intersects(eventRectangle[map][col][row]) && eventRectangle[map][col][row].eventDone == false) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;
                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRectangle[map][col][row].x = eventRectangle[map][col][row].eventRectDefaultX;
            eventRectangle[map][col][row].y = eventRectangle[map][col][row].eventRectDefaultY;
        }
        return hit;

    }
}
