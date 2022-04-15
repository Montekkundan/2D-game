package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldColumn][gp.maxWorldRow];
        loadMap("res/maps/world001.txt");
        getTileImage();

    }
    public void getTileImage(){
        InputStream t_1 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass.png");
        InputStream t_2 = getClass().getClassLoader().getResourceAsStream("res/tiles/wall.png");
        InputStream t_3 = getClass().getClassLoader().getResourceAsStream("res/tiles/water00.png");
        InputStream t_4 = getClass().getClassLoader().getResourceAsStream("res/tiles/water01.png");
        InputStream t_5 = getClass().getClassLoader().getResourceAsStream("res/tiles/tree.png");
        InputStream t_6 = getClass().getClassLoader().getResourceAsStream("res/tiles/earth.png");
        InputStream t_7 = getClass().getClassLoader().getResourceAsStream("res/tiles/swamp.png");

        try {
            tile[0] = new Tile();
            assert t_1 != null;
            tile[0].image = new ImageIcon(ImageIO.read(t_1));

            tile[1] = new Tile();
            assert t_2 != null;
            tile[1].image = new ImageIcon(ImageIO.read(t_2));
            tile[1].collision = true;

            tile[2] = new Tile();
            assert t_3 != null;
            tile[2].image = new ImageIcon(ImageIO.read(t_3));
            tile[2].collision = true;

            tile[3] = new Tile();
            assert t_4 != null;
            tile[3].image = new ImageIcon(ImageIO.read(t_4));
            tile[3].collision = true;

            tile[4] = new Tile();
            assert t_5 != null;
            tile[4].image = new ImageIcon(ImageIO.read(t_5));
            tile[4].collision = true;

            tile[5] = new Tile();
            assert t_6 != null;
            tile[5].image = new ImageIcon(ImageIO.read(t_6));

            tile[6] = new Tile();
            assert t_7 != null;
            tile[6].image = new ImageIcon(ImageIO.read(t_7));
            tile[6].collision = true;

            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < gp.maxWorldColumn && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col<gp.maxWorldColumn){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldColumn){
                    col= 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

//        g2.drawImage(tile[0].image.getImage(), 0,0,gp.tileSize, gp.tileSize,null);
//        g2.drawImage(tile[1].image.getImage(), 48,0,gp.tileSize, gp.tileSize,null);
//        g2.drawImage(tile[2].image.getImage(), 96,0,gp.tileSize, gp.tileSize,null);
//        int col = 0;
//        int row = 0;
//        int x = 0;
//        int y = 0;
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldColumn && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNum].image.getImage(), screenX , screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;
//            x += gp.tileSize;
            if(worldCol == gp.maxWorldColumn){
                worldCol = 0;
//                x= 0;
                worldRow++;
//                y += gp.tileSize;
            }
        }

        /*
        for(row = 0; row< mapTileNum.length; row++) {
            for(col= 0; col < mapTileNum[row].length; col++) {
                g2.drawImage(tile[col].image.getImage(), x , y, gp.tileSize, gp.tileSize, null);
                col++;
                x += gp.tileSize;
            }
            x=0;
            row++;
            y += gp.tileSize;
        }
        */

    }
}

