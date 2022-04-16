package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
//    public int hasKeys = 0;
    boolean moving = false;
    int pixelCounter = 0;
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 1; // 8 if not tile bases movement
        solidArea.y= 1; //  16 if not tile based movement
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 46; // 32 if not tile based movement
        solidArea.height = 46; // 32 if not tile based movement

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX= gp.tileSize * 23;
        worldY= gp.tileSize * 21 ;
        speed =4;
        direction = "down";
    }
    public void getPlayerImage() {
        InputStream d_1 = getClass().getClassLoader().getResourceAsStream("res/player/tile001.png");
        InputStream d_2 = getClass().getClassLoader().getResourceAsStream("res/player/tile002.png");
        InputStream u_1 = getClass().getClassLoader().getResourceAsStream("res/player/tile009.png");
        InputStream u_2 = getClass().getClassLoader().getResourceAsStream("res/player/tile011.png");
        InputStream l_1 = getClass().getClassLoader().getResourceAsStream("res/player/tile003.png");
        InputStream l_2 = getClass().getClassLoader().getResourceAsStream("res/player/tile005.png");
        InputStream r_1 = getClass().getClassLoader().getResourceAsStream("res/player/tile006.png");
        InputStream r_2 = getClass().getClassLoader().getResourceAsStream("res/player/tile008.png");

        try{
            assert d_1 != null;
            down1 = new ImageIcon(ImageIO.read(d_1));
            assert d_2 != null;
            down2 = new ImageIcon(ImageIO.read(d_2));
            assert u_1 != null;
            up1 = new ImageIcon(ImageIO.read(u_1));
            assert u_2 != null;
            up2 = new ImageIcon(ImageIO.read(u_2));
            assert l_1 != null;
            left1 = new ImageIcon(ImageIO.read(l_1));
            assert l_2 != null;
            left2 = new ImageIcon(ImageIO.read(l_2));
            assert r_1 != null;
            right1 = new ImageIcon(ImageIO.read(r_1));
            assert r_2 != null;
            right2 = new ImageIcon(ImageIO.read(r_2));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(moving == false){
            if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
                if (keyH.upPressed) {
                    direction = "up";

                } else if (keyH.downPressed) {
                    direction = "down";

                } else if (keyH.leftPressed) {
                    direction = "left";

                } else if (keyH.rightPressed) {
                    direction = "right";

                }
                moving = true;
                // Check tile collision
                collisionOn = false;
                gp.cChecker.checkTile(this);

                // check object collision
                int objIndex = gp.cChecker.checkObject(this, true);
                pickUpObject(objIndex);
            }
        }
        if(moving == true){
            // If collision is false, player can move.
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
            pixelCounter += speed;
            if(pixelCounter == 48){
                moving = false;
                pixelCounter =0;
            }
        }
    }

    public void pickUpObject(int i){
        if(i != 999){

            // For treasure game, picking key, boots and opening doors.
            /*
            String objectName = gp.obj[i].name;
            switch (objectName){
                case "Key":
                    gp.playSoundEffect(1);
                    hasKeys++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You picked a Key!");
                    System.out.println("keys :" +hasKeys);
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
                    System.out.println("keys :" +hasKeys);
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

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y,gp.tileSize, gp.tileSize);
        ImageIcon image = null;
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
        assert image != null;
        g2.drawImage(image.getImage(), screenX , screenY, gp.tileSize, gp.tileSize, null);
        // detection collision area, red rectangle on player
//        g2.setColor(Color.red);
//        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}
