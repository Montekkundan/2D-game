package main;

import object.Hearts;
import object.Key;
import object.SuperObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40 , arial_80, maruMonica;
    ImageIcon heart_full, heart_half, heart_blank;
//    Image keyImage;
    public boolean messageOn = false;
    public String message = "";
//    int messageCounter = 0;
//    public boolean gameFinished = false;
//    double playTime;
//    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public String currentDialogue = "";
    public int commandNumber =0;
    public int titleScreenState = 0;
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
        SuperObject heart = new Hearts(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;


//        Key key = new Key();
//        keyImage = key.image.getImage();
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
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
        int x  = gp.tileSize/2;
        int y  = gp.tileSize/2;
        int i =0;
        //Drawing blank heart
        while(i<gp.player.maxLife/2){
            g2.drawImage(heart_blank.getImage(),x,y,gp.tileSize,gp.tileSize,null);
            i++;
            x+=gp.tileSize;
        }
        // reset
        x  = gp.tileSize/2;
        y  = gp.tileSize/2;
        i =0;

        //draw current life
        while(i<gp.player.life){
            g2.drawImage(heart_half.getImage(),x,y,gp.tileSize,gp.tileSize,null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full.getImage(),x,y,gp.tileSize,gp.tileSize,null);
            }
            i++;
            x+=gp.tileSize;
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
            InputStream s = getClass().getClassLoader().getResourceAsStream("res/warrior/tile001.png");
            InputStream s_1 = getClass().getClassLoader().getResourceAsStream("res/npc/tile000.png");

            ImageIcon stand = null;
            ImageIcon stand_1 = null;
            try {
                assert s != null;
                stand = new ImageIcon(ImageIO.read(s));
                assert s_1 != null;
                stand_1 = new ImageIcon(ImageIO.read(s_1));
            } catch (Exception e) {
                e.printStackTrace();
            }
            assert stand != null;
            assert stand_1 != null;
            g2.drawImage(stand_1.getImage(), (int) (x+(gp.tileSize*1.5)), y, gp.tileSize * 2, gp.tileSize * 2, null);
            g2.drawImage(stand.getImage(), x, y, gp.tileSize * 2, gp.tileSize * 2, null);

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
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(25,25,25, 220);
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
}
