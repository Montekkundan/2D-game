package main;

import object.Key;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40 , arial_80, maruMonica;
//    Image keyImage;
    public boolean messageOn = false;
    public String message = "";
//    int messageCounter = 0;
//    public boolean gameFinished = false;
//    double playTime;
//    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public String currentDialogue = "";
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
        //Playstate
        if(gp.gameState == gp.playState){

        }
        //Pausestate
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //Dialogue state
        if(gp.gameState == gp.dialogueState){
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
