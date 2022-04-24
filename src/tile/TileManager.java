package tile;

import main.GamePanel;
import main.UtilityTool;

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
        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldColumn][gp.maxWorldRow];
        loadMap("res/maps/worldv2.txt");
        getTileImage();

    }
    public void getTileImage(){
        try {
            setup(0,"grass00", false);
            setup(1,"grass00", false);
            setup(2,"grass00", false);
            setup(3,"grass00", false);
            setup(4,"grass00", false);
            setup(5,"grass00", false);
            setup(6,"grass00", false);
            setup(7,"grass00", false);
            setup(8,"grass00", false);
            setup(9,"grass00", false);
            // placeholder
            setup(10,"grass00", false);
            setup(11,"grass01", false);
            //water
            setup(12,"water00", true);
            setup(13,"water01", true);
            setup(14,"water02", true);
            setup(15,"water03", true);
            setup(16,"water04", true);
            setup(17,"water05", true);
            setup(18,"water06", true);
            setup(19,"water07", true);
            setup(20,"water08", true);
            setup(21,"water09", true);
            setup(22,"water10", true);
            setup(23,"water11", true);
            setup(24,"water12", true);
            setup(25,"water13", true);
            //road
            setup(26,"road00", false);
            setup(27,"road01", false);
            setup(28,"road02", false);
            setup(29,"road03", false);
            setup(30,"road04", false);
            setup(31,"road05", false);
            setup(32,"road06", false);
            setup(33,"road07", false);
            setup(34,"road08", false);
            setup(35,"road09", false);
            setup(36,"road10", false);
            setup(37,"road11", false);
            setup(38,"road12", false);
            // other
            setup(39,"earth", false);
            setup(40,"wall", true);
            setup(41,"tree", true);
            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setup(int index, String imagePath, boolean collision){
        UtilityTool utool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" +imagePath+".png"));
            tile[index].image = utool.scaleImage(tile[index].image,gp.tileSize,gp.tileSize);
            tile[index].collision = collision;
        }
        catch (Exception e){
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
                g2.drawImage(tile[tileNum].image, screenX , screenY,null);
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

