package main;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    // Screen Settings
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48 x 48 tile
    public final int maxScreenColumn  = 16;
    public final int maxScreenRow  = 12;
    public final int screenWidth  = tileSize * maxScreenColumn; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // World Settings
    public final int maxWorldColumn = 50;
    public final int maxWorldRow = 50;
//    public final int worldWidth = tileSize * maxWorldColumn;
//    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;
    //System
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    // Entity
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];

    //Game State
    public int gameState=0;
    public final int playState=1;
    public final int pauseState = 2;
    public final int dialogueState = 3;


    public GamePanel() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
    public void setUpGame(){
        aSetter.setObject();
        aSetter.setNpc();
        playMusic(0);
        gameState = playState;
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // Sleep method
//    public void run() {
//        double drawInterval = 1000000000/FPS; // 1 billion nano seconds for precise calculations, 0.0166666 seconds.
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        while(gameThread != null){
//            update();
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000; // nanoseconds to milliseconds
//                if (remainingTime < 0){
//                    remainingTime = 0;
//                }
//                Thread.sleep((long)remainingTime);
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    // Delta method
    public void run() {
        double drawInterval = 1000000000/FPS; // 1 billion nano seconds for precise calculations, 0.0166666 seconds.
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/ drawInterval;
            lastTime = currentTime;
            if(delta >=1){
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update(){
        if(gameState == playState){
            // Player
            player.update();
            // Npc
            for (int i = 0; i<npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
        }
        if(gameState == pauseState){

        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Tile
        tileM.draw(g2);
        //Object
        for(int i =0; i< obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        // Npc
        for (int i = 0; i<npc.length; i++){
            if(npc[i] != null){
                npc[i].draw(g2);
            }
        }

        //Player
        player.draw(g2);

        // UI
        ui.draw(g2);
        g2.dispose();
    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSoundEffect(int i){
        se.setFile(i);
        se.play();
    }
}
