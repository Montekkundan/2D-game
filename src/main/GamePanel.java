package main;

import entity.Entity;
import entity.Player;
import tile.TileManager;
import tile_interactive.InteractiveTile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable{
    // Screen Settings
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48 x 48 tile
    public final int maxScreenColumn  = 20;
    public final int maxScreenRow  = 12;
    public final int screenWidth  = tileSize * maxScreenColumn; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //full screen
    public boolean fullScreenOn = false;

    // World Settings
    public final int maxWorldColumn = 50;
    public final int maxWorldRow = 50;
//    public final int worldWidth = tileSize * maxWorldColumn;
//    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;
    //System
    public UI ui = new UI(this);
    public KeyHandler keyH = new KeyHandler(this);
    TileManager tileM = new TileManager(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);
    Config config = new Config(this);
    Thread gameThread;

    // Entity
    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[20];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    public InteractiveTile iTile[] = new InteractiveTile[50];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    public ArrayList<Entity> particleList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();


    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState=1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionState = 5;


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
        aSetter.setMonster();
        aSetter.setInteractiveTile();
//        playMusic(0);
        gameState = titleState;
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
            //monster
            for (int i = 0; i<monster.length; i++){
                if(monster[i] != null){
                    if(monster[i].alive == true && monster[i].dying == false) {
                        monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i].checkDrop();
                        monster[i] = null;
                    }
                }
            }
            for (int i = 0; i<projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    if(projectileList.get(i).alive == true) {
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive == false){
                        projectileList.remove(i);
                    }
                }
            }
            for (int i = 0; i<particleList.size(); i++){
                if(particleList.get(i) != null){
                    if(particleList.get(i).alive == true) {
                        particleList.get(i).update();
                    }
                    if(particleList.get(i).alive == false){
                        particleList.remove(i);
                    }
                }
            }
            for(int i = 0;i<iTile.length; i++){
                if(iTile[i] != null){
                    iTile[i].update();
                }
            }
        }
        if(gameState == pauseState){
            //do nothing
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Title Screen
        if(gameState == titleState){
            ui.draw(g2);
        }
        else {
            //Tile
            tileM.draw(g2);

            // interactive tile
            for(int i = 0;i<iTile.length; i++){
                if(iTile[i] != null){
                    iTile[i].draw(g2);
                }
            }

            // Add entity to the list
            entityList.add(player);
            for (int i =0; i<npc.length;i++){
                if(npc[i]!=null){
                    entityList.add(npc[i]);
                }
            }
            for (int i =0; i<obj.length;i++){
                if(obj[i]!=null){
                    entityList.add(obj[i]);
                }
            }
            for (int i = 0; i<monster.length; i++){
                if(monster[i] != null){
                    entityList.add(monster[i]);
                }
            }
            for (int i = 0; i< projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
            }
            for (int i = 0; i< particleList.size(); i++){
                if(particleList.get(i) != null){
                    entityList.add(particleList.get(i));
                }
            }

            //sort
            Collections.sort(entityList, (e1, e2) -> Integer.compare(e1.worldX, e2.worldY));

            // draw entities
            for (int i =0; i<entityList.size();i++){
                entityList.get(i).draw(g2);
            }

            //empty entity list
            entityList.clear();

            // UI
            ui.draw(g2);
        }
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
