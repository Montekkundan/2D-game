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
            InputStream s = getClass().getClassLoader().getResourceAsStream("res/warrior/tile000.png");
            InputStream d_1 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile000.png");
            InputStream d_2 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile002.png");
            InputStream u_1 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile009.png");
            InputStream u_2 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile011.png");
            InputStream l_1 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile003.png");
            InputStream l_2 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile005.png");
            InputStream r_1 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile006.png");
            InputStream r_2 = getClass().getClassLoader().getResourceAsStream("res/warrior/tile008.png");

            try {

                assert s != null;
                stand = new ImageIcon(ImageIO.read(s));
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if(playerSelector == 1) {
            InputStream s = getClass().getClassLoader().getResourceAsStream("res/mage/tile001.png");
            InputStream d_1 = getClass().getClassLoader().getResourceAsStream("res/mage/tile000.png");
            InputStream d_2 = getClass().getClassLoader().getResourceAsStream("res/mage/tile002.png");
            InputStream u_1 = getClass().getClassLoader().getResourceAsStream("res/mage/tile009.png");
            InputStream u_2 = getClass().getClassLoader().getResourceAsStream("res/mage/tile011.png");
            InputStream l_1 = getClass().getClassLoader().getResourceAsStream("res/mage/tile003.png");
            InputStream l_2 = getClass().getClassLoader().getResourceAsStream("res/mage/tile005.png");
            InputStream r_1 = getClass().getClassLoader().getResourceAsStream("res/mage/tile006.png");
            InputStream r_2 = getClass().getClassLoader().getResourceAsStream("res/mage/tile008.png");

            try {

                assert s != null;
                stand = new ImageIcon(ImageIO.read(s));
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(playerSelector == 2) {
            InputStream s = getClass().getClassLoader().getResourceAsStream("res/assassin/tile001.png");
            InputStream d_1 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile000.png");
            InputStream d_2 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile002.png");
            InputStream u_1 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile009.png");
            InputStream u_2 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile011.png");
            InputStream l_1 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile003.png");
            InputStream l_2 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile005.png");
            InputStream r_1 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile006.png");
            InputStream r_2 = getClass().getClassLoader().getResourceAsStream("res/assassin/tile008.png");

            try {

                assert s != null;
                stand = new ImageIcon(ImageIO.read(s));
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(playerSelector == 3) {
            InputStream s = getClass().getClassLoader().getResourceAsStream("res/santa/tile001.png");
            InputStream d_1 = getClass().getClassLoader().getResourceAsStream("res/santa/tile000.png");
            InputStream d_2 = getClass().getClassLoader().getResourceAsStream("res/santa/tile002.png");
            InputStream u_1 = getClass().getClassLoader().getResourceAsStream("res/santa/tile009.png");
            InputStream u_2 = getClass().getClassLoader().getResourceAsStream("res/santa/tile011.png");
            InputStream l_1 = getClass().getClassLoader().getResourceAsStream("res/santa/tile003.png");
            InputStream l_2 = getClass().getClassLoader().getResourceAsStream("res/santa/tile005.png");
            InputStream r_1 = getClass().getClassLoader().getResourceAsStream("res/santa/tile006.png");
            InputStream r_2 = getClass().getClassLoader().getResourceAsStream("res/santa/tile008.png");

            try {

                assert s != null;
                stand = new ImageIcon(ImageIO.read(s));
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

            } catch (Exception e) {
                e.printStackTrace();
            }
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
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        assert image != null;
        g2.drawImage(image.getImage(), screenX , screenY, gp.tileSize, gp.tileSize, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // detection collision area, red rectangle on player
//        g2.setColor(Color.red);
//        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}