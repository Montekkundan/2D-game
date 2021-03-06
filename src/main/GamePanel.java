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
    public final int maxMap = 10;
    public int currentMap = 0;
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
    public Entity obj[][] = new Entity[maxMap][100];
    public Entity npc[][] = new Entity[maxMap][10];
    public Entity monster[][] = new Entity[maxMap][20];
    public InteractiveTile iTile[][] = new InteractiveTile[maxMap][50];
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
    public final int gameOverState = 6;


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
    public void retry(){
        player.setDefaultPositions();
        player.restoreLifeAndMana();
        aSetter.setNpc();
        aSetter.setMonster();
    }
    public void restart(){
        player.setDefaultValues();
        player.setDefaultPositions();
        player.restoreLifeAndMana();
        player.setItems();
        aSetter.setObject();
        aSetter.setNpc();
        aSetter.setMonster();
        aSetter.setInteractiveTile();
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
            for (int i = 0; i<npc[1].length; i++){
                if(npc[currentMap][i] != null){
                    npc[currentMap][i].update();
                }
            }
            //monster
            for (int i = 0; i<monster[1].length; i++){
                if(monster[currentMap][i] != null){
                    if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false) {
                        monster[currentMap][i].update();
                    }
                    if(monster[currentMap][i].alive == false){
                        monster[currentMap][i].checkDrop();
                        monster[currentMap][i] = null;
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
            for(int i = 0;i<iTile[1].length; i++){
                if(iTile[currentMap][i] != null){
                    iTile[currentMap][i].update();
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
            //Debug
            long drawStart = 0;
            if(keyH.showDebugText == true){
            drawStart = System.nanoTime();
            }

            //Tile
            tileM.draw(g2);

            // interactive tile
            for(int i = 0;i<iTile[1].length; i++){
                if(iTile[currentMap][i] != null){
                    iTile[currentMap][i].draw(g2);
                }
            }

            // Add entity to the list
            entityList.add(player);
            for (int i =0; i<npc[1].length;i++){
                if(npc[currentMap][i]!=null){
                    entityList.add(npc[currentMap][i]);
                }
            }
            for (int i =0; i<obj[1].length;i++){
                if(obj[currentMap][i]!=null){
                    entityList.add(obj[currentMap][i]);
                }
            }
            for (int i = 0; i<monster[1].length; i++){
                if(monster[currentMap][i] != null){
                    entityList.add(monster[currentMap][i]);
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

            // Debug
            if(keyH.showDebugText == true) {
                long drawEnd = System.nanoTime();
                long passed = drawEnd - drawStart;
                g2.setColor(Color.white);
                int x = 10;
                int y = 400;
                int lineHeight = 30;
                g2.drawString("WorldX: "+player.worldX,x,y); y += lineHeight;
                g2.drawString("WorldY: "+player.worldY,x,y);y+=lineHeight;
                g2.drawString("Col: "+(player.worldX + player.solidArea.x)/tileSize,x,y);y+=lineHeight;
                g2.drawString("Row: "+(player.worldY + player.solidArea.y)/tileSize,x,y);y+=lineHeight;
                g2.drawString("Draw Time: " + passed, x, y);
            }

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
