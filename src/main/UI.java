package main;

import entity.Entity;
import object.Hearts;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40 , arial_80, maruMonica;
    BufferedImage heart_full;
    BufferedImage heart_half;
    BufferedImage heart_blank;
//    Image keyImage;
    public boolean messageOn = false;
//    public String message = "";
//    int messageCounter = 0;
//    public boolean gameFinished = false;
//    double playTime;
//    DecimalFormat dFormat = new DecimalFormat("#0.00");
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();
    public String currentDialogue = "";
    public int commandNumber =0;
    public int titleScreenState = 0;
    public int slotCol = 0;
    public int slotRow = 0;
    public UI(GamePanel gp){
        this.gp =gp;
        arial_40 = new Font("Arial",Font.BOLD, 40);
        arial_80 = new Font("Arial",Font.BOLD, 80);
        InputStream is = getClass().getResourceAsStream("/res/font/MaruMonica.ttf");
        try {
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // Create HUD object
        Entity heart = new Hearts(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;


//        Key key = new Key();
//        keyImage = key.image.getImage();
    }
    public void addMessage(String text){
//        message = text;
//        messageOn = true;
        message.add(text);
        messageCounter.add(0);
    }
    public void draw(Graphics2D g2){

        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setColor(Color.white);

        //TitleState
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }

        //Playstate
        if(gp.gameState == gp.playState){
            drawPlayerLife();
            drawMessage();
        }
        //Pausestate
        if(gp.gameState == gp.pauseState){
            drawPlayerLife();
            drawPauseScreen();
        }
        //Dialogue state
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawDialogueScreen();
        }
        //Character State
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
            drawInventory();
        }

        // Treasure finding game UI
        /*

        if(gameFinished == true){
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            String text;
            int textLength;
            int x;
            int y;
            text = "You found the Treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x ,y);

            text = "Your time is: "+ dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*4);
            g2.drawString(text, x ,y);

            g2.setFont(arial_40);
            g2.setColor(Color.yellow);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x ,y);
            gp.gameThread = null;
        }
        else{
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x = "+gp.player.hasKeys, 74, 65);

            // Time
            playTime += (double)1/60;
            g2.drawString("Time:"+ dFormat.format(playTime), gp.tileSize*11, 65);

            // Message
            if(messageOn == true){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
                messageCounter++;
                if(messageCounter > 120){ // message disappears after 2 seconds
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
         */
    }

    private void drawPlayerLife() {
//        gp.player.life = 6;
        int x  = gp.tileSize/2;
        int y  = gp.tileSize/2;
        int i =0;
        //Drawing blank heart
        while(i<gp.player.maxLife/2){
            g2.drawImage(heart_blank,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            x+=gp.tileSize;
        }
        // reset
        x  = gp.tileSize/2;
        y  = gp.tileSize/2;
        i =0;

        //draw current life
        while(i<gp.player.life){
            g2.drawImage(heart_half,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full,x,y,gp.tileSize,gp.tileSize,null);
            }
            i++;
            x+=gp.tileSize;
        }
    }
    public void drawMessage(){
        int messageX = gp.tileSize;
        int messageY = gp.tileSize *4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 28F));
        for (int i =0; i<message.size();i++){
            if(message.get(i) != null){
                g2.setColor(Color.black);
                g2.drawString(message.get(i), messageX+2, messageY+2);
                g2.setColor(Color.white);
                g2.drawString(message.get(i), messageX, messageY);

                int counter = messageCounter.get(i)+1; // messageCounter++
                messageCounter.set(i, counter); //set the counter to the array
                messageY += 40;

                if(messageCounter.get(i) > 180){
                    message.remove(i);
                    messageCounter.remove(i);

                }
            }
        }
    }
    private void drawTitleScreen() {
        if(titleScreenState == 0) {
            Color c = new Color(25, 25, 25);
            g2.setColor(c);
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // Title name
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Adventure Game";
            int x = gettingCenterText(text);
            int y = gp.tileSize * 3;
            //text shadow
            g2.setColor(Color.red);
            g2.drawString(text, x + 5, y + 5);
            //main text color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            // character image
            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
            y += gp.tileSize * 2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            //menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
            text = "NEW GAME";
            x = gettingCenterText(text);
            y += gp.tileSize * 3.5;
            g2.drawString(text, x, y);
            if (commandNumber == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = gettingCenterText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNumber == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "QUIT";
            x = gettingCenterText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNumber == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }
        else if(titleScreenState == 1){
            Color c = new Color(25, 25, 25);
            g2.setColor(c);
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // class slection screen
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 42F));
            String text = "Select your class";
            int x = gettingCenterText(text);
            int y = gp.tileSize*3;
            g2.drawString(text, x, y);

            text = "WARRIOR";
            x = gettingCenterText(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if (commandNumber == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Mage";
            x = gettingCenterText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNumber == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Assassin";
            x = gettingCenterText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNumber == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Santa";
            x = gettingCenterText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNumber == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Back";
            x = gettingCenterText(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if (commandNumber == 4) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }

    }

    private void drawDialogueScreen() {
        //Window
        int x = gp.tileSize *2;
        int y = gp.tileSize /2;
        int width= gp.screenWidth - (gp.tileSize *4);
        int height= gp.tileSize *4;
        drawSubWindow(x,y,width,height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
        x+= gp.tileSize;
        y+= gp.tileSize;
        for(String line: currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }
    public void drawCharacterScreen(){
        // create frame
        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = gp.tileSize*10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 35;
        
        //names
        g2.drawString("Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Life",textX, textY);
        textY += lineHeight;
        g2.drawString("Strength",textX, textY);
        textY += lineHeight;
        g2.drawString("Dexterity",textX, textY);
        textY += lineHeight;
        g2.drawString("Attack",textX, textY);
        textY += lineHeight;
        g2.drawString("Defence",textX, textY);
        textY += lineHeight;
        g2.drawString("Exp",textX, textY);
        textY += lineHeight;
        g2.drawString("Next Level",textX, textY);
        textY += lineHeight;
        g2.drawString("Coins",textX, textY);
        textY += lineHeight+20;
        g2.drawString("Weapon",textX, textY);
        textY += lineHeight+15;
        g2.drawString("Shield",textX, textY);
        textY += lineHeight;

        // values
        int tailX = (frameX + frameWidth) - 30;
        //reset textY
        textY = frameY + gp.tileSize;
        String value;

        value = String.valueOf(gp.player.level);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.strength);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.dexterity);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.defence);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.exp);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.nextLevelExp);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = gettingTextAlignRight(value,tailX);
        g2.drawString(value, textX,textY);
        textY += lineHeight;

        g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY-14, null);
        textY += gp.tileSize;
        g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY-14, null);

    }
    public void drawInventory(){
        // create frame
        final int frameX = gp.tileSize*9;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*6;
        final int frameHeight = gp.tileSize*5;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //slot
        final int slotXStart = frameX + 20;
        final int slotYStart = frameY + 20;
        int slotX = slotXStart;
        int slotY = slotYStart;
        int slotSize = gp.tileSize+3;
        
        // draw player's items
        for (int i = 0; i<gp.player.inventory.size();i++){
            //equip cursor
            if(gp.player.inventory.get(i) == gp.player.currentWeapon || gp.player.inventory.get(i) == gp.player.currentShield){
                g2.setColor(new Color(240,190,90));
                g2.fillRoundRect(slotX,slotY,gp.tileSize,gp.tileSize,10,10);
            }
            g2.drawImage(gp.player.inventory.get(i).down1,slotX, slotY, null);
            slotX += slotSize;
            if(i== 4 || i == 9 || i == 14){
                slotX = slotXStart;
                slotY += slotSize;
            }
        }

        //cursor
        int cursorX = slotXStart + (slotSize * slotCol);
        int cursorY = slotYStart + (slotSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;

        //draw cursor
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY,cursorWidth, cursorHeight,10,10);

        // description frame
        int dFrameX = frameX;
        int dFrameY = frameY + frameHeight;
        int dFrameWidth = frameWidth;
        int dFrameHeight = gp.tileSize*3;


        // draw description
        int textX = dFrameX +20;
        int textY = dFrameY +gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(28F));

        int itemIndex = getItemIndexOnSlot();
        if(itemIndex < gp.player.inventory.size()){
            drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
            for(String line: gp.player.inventory.get(itemIndex).description.split("\n")){
            g2.drawString(line, textX, textY);
            textY += 32;
            }
        }


    }
    public int getItemIndexOnSlot(){
        int itemIndex = slotCol + (slotRow *5);
        return itemIndex;
    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(25,25,25, 230);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(120F));
        String text = "PAUSED";
        int x = gettingCenterText(text);

        int y = gp.screenHeight/2;
        g2.drawString(text, x ,y);
    }
    public int gettingCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }
    public int gettingTextAlignRight(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return tailX - length;
    }
}
