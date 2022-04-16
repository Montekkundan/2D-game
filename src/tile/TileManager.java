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
        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldColumn][gp.maxWorldRow];
        loadMap("res/maps/worldv2.txt");
        getTileImage();

    }
    public void getTileImage(){
        //Unused tiles
        InputStream t_1 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_2 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_3 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_4 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_5 =getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_6 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_7 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_8 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_9 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_10 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        //Using tiles
        InputStream t_11 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass00.png");
        InputStream t_12 = getClass().getClassLoader().getResourceAsStream("res/tiles/grass01.png");
        InputStream t_13 = getClass().getClassLoader().getResourceAsStream("res/tiles/water00.png");
        InputStream t_14 = getClass().getClassLoader().getResourceAsStream("res/tiles/water01.png");
        InputStream t_15 = getClass().getClassLoader().getResourceAsStream("res/tiles/water02.png");
        InputStream t_16 = getClass().getClassLoader().getResourceAsStream("res/tiles/water03.png");
        InputStream t_17 = getClass().getClassLoader().getResourceAsStream("res/tiles/water04.png");
        InputStream t_18 = getClass().getClassLoader().getResourceAsStream("res/tiles/water05.png");
        InputStream t_19 = getClass().getClassLoader().getResourceAsStream("res/tiles/water06.png");
        InputStream t_20 = getClass().getClassLoader().getResourceAsStream("res/tiles/water07.png");
        InputStream t_21 = getClass().getClassLoader().getResourceAsStream("res/tiles/water08.png");
        InputStream t_22 = getClass().getClassLoader().getResourceAsStream("res/tiles/water09.png");
        InputStream t_23 = getClass().getClassLoader().getResourceAsStream("res/tiles/water10.png");
        InputStream t_24 = getClass().getClassLoader().getResourceAsStream("res/tiles/water11.png");
        InputStream t_25 = getClass().getClassLoader().getResourceAsStream("res/tiles/water12.png");
        InputStream t_26 = getClass().getClassLoader().getResourceAsStream("res/tiles/water13.png");
        InputStream t_27 = getClass().getClassLoader().getResourceAsStream("res/tiles/road00.png");
        InputStream t_28 = getClass().getClassLoader().getResourceAsStream("res/tiles/road01.png");
        InputStream t_29 = getClass().getClassLoader().getResourceAsStream("res/tiles/road02.png");
        InputStream t_30 = getClass().getClassLoader().getResourceAsStream("res/tiles/road03.png");
        InputStream t_31 = getClass().getClassLoader().getResourceAsStream("res/tiles/road04.png");
        InputStream t_32 = getClass().getClassLoader().getResourceAsStream("res/tiles/road05.png");
        InputStream t_33 = getClass().getClassLoader().getResourceAsStream("res/tiles/road06.png");
        InputStream t_34 = getClass().getClassLoader().getResourceAsStream("res/tiles/road07.png");
        InputStream t_35 = getClass().getClassLoader().getResourceAsStream("res/tiles/road08.png");
        InputStream t_36 = getClass().getClassLoader().getResourceAsStream("res/tiles/road09.png");
        InputStream t_37 = getClass().getClassLoader().getResourceAsStream("res/tiles/road10.png");
        InputStream t_38 = getClass().getClassLoader().getResourceAsStream("res/tiles/road11.png");
        InputStream t_39 = getClass().getClassLoader().getResourceAsStream("res/tiles/road12.png");
        InputStream t_40 = getClass().getClassLoader().getResourceAsStream("res/tiles/earth.png");
        InputStream t_41 = getClass().getClassLoader().getResourceAsStream("res/tiles/wall.png");
        InputStream t_42 = getClass().getClassLoader().getResourceAsStream("res/tiles/tree.png");


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

            tile[3] = new Tile();
            assert t_4 != null;
            tile[3].image = new ImageIcon(ImageIO.read(t_4));

            tile[4] = new Tile();
            assert t_5 != null;
            tile[4].image = new ImageIcon(ImageIO.read(t_5));

            tile[5] = new Tile();
            assert t_6 != null;
            tile[5].image = new ImageIcon(ImageIO.read(t_6));

            tile[6] = new Tile();
            assert t_7 != null;
            tile[6].image = new ImageIcon(ImageIO.read(t_7));

            tile[7] = new Tile();
            assert t_8 != null;
            tile[7].image = new ImageIcon(ImageIO.read(t_8));

            tile[8] = new Tile();
            assert t_9 != null;
            tile[8].image = new ImageIcon(ImageIO.read(t_9));

            tile[9] = new Tile();
            assert t_10 != null;
            tile[9].image = new ImageIcon(ImageIO.read(t_10));

            tile[10] = new Tile();
            assert t_11 != null;
            tile[10].image = new ImageIcon(ImageIO.read(t_11));

            tile[11] = new Tile();
            assert t_12 != null;
            tile[11].image = new ImageIcon(ImageIO.read(t_12));

            tile[12] = new Tile();
            assert t_13 != null;
            tile[12].image = new ImageIcon(ImageIO.read(t_13));
            tile[12].collision = true;

            tile[13] = new Tile();
            assert t_14 != null;
            tile[13].image = new ImageIcon(ImageIO.read(t_14));
            tile[13].collision = true;

            tile[14] = new Tile();
            assert t_15 != null;
            tile[14].image = new ImageIcon(ImageIO.read(t_15));
            tile[14].collision = true;

            tile[15] = new Tile();
            assert t_16 != null;
            tile[15].image = new ImageIcon(ImageIO.read(t_16));
            tile[15].collision = true;

            tile[16] = new Tile();
            assert t_17 != null;
            tile[16].image = new ImageIcon(ImageIO.read(t_17));
            tile[16].collision = true;

            tile[17] = new Tile();
            assert t_18 != null;
            tile[17].image = new ImageIcon(ImageIO.read(t_18));
            tile[17].collision = true;

            tile[18] = new Tile();
            assert t_19 != null;
            tile[18].image = new ImageIcon(ImageIO.read(t_19));
            tile[18].collision = true;

            tile[19] = new Tile();
            assert t_20 != null;
            tile[19].image = new ImageIcon(ImageIO.read(t_20));
            tile[19].collision = true;

            tile[20] = new Tile();
            assert t_21 != null;
            tile[20].image = new ImageIcon(ImageIO.read(t_21));
            tile[20].collision = true;

            tile[21] = new Tile();
            assert t_22 != null;
            tile[21].image = new ImageIcon(ImageIO.read(t_22));
            tile[21].collision = true;

            tile[22] = new Tile();
            assert t_23 != null;
            tile[22].image = new ImageIcon(ImageIO.read(t_23));
            tile[22].collision = true;

            tile[23] = new Tile();
            assert t_24 != null;
            tile[23].image = new ImageIcon(ImageIO.read(t_24));
            tile[23].collision = true;

            tile[24] = new Tile();
            assert t_25 != null;
            tile[24].image = new ImageIcon(ImageIO.read(t_25));
            tile[24].collision = true;

            tile[25] = new Tile();
            assert t_26 != null;
            tile[25].image = new ImageIcon(ImageIO.read(t_26));
            tile[25].collision = true;

            tile[26] = new Tile();
            assert t_27 != null;
            tile[26].image = new ImageIcon(ImageIO.read(t_27));

            tile[27] = new Tile();
            assert t_28 != null;
            tile[27].image = new ImageIcon(ImageIO.read(t_28));

            tile[28] = new Tile();
            assert t_29 != null;
            tile[28].image = new ImageIcon(ImageIO.read(t_29));

            tile[29] = new Tile();
            assert t_30 != null;
            tile[29].image = new ImageIcon(ImageIO.read(t_30));

            tile[30] = new Tile();
            assert t_31 != null;
            tile[30].image = new ImageIcon(ImageIO.read(t_31));

            tile[31] = new Tile();
            assert t_32 != null;
            tile[31].image = new ImageIcon(ImageIO.read(t_32));

            tile[32] = new Tile();
            assert t_33 != null;
            tile[32].image = new ImageIcon(ImageIO.read(t_33));

            tile[33] = new Tile();
            assert t_34 != null;
            tile[33].image = new ImageIcon(ImageIO.read(t_34));

            tile[34] = new Tile();
            assert t_35 != null;
            tile[34].image = new ImageIcon(ImageIO.read(t_35));

            tile[35] = new Tile();
            assert t_36 != null;
            tile[35].image = new ImageIcon(ImageIO.read(t_36));

            tile[36] = new Tile();
            assert t_37 != null;
            tile[36].image = new ImageIcon(ImageIO.read(t_37));

            tile[37] = new Tile();
            assert t_38 != null;
            tile[37].image = new ImageIcon(ImageIO.read(t_38));

            tile[38] = new Tile();
            assert t_39 != null;
            tile[38].image = new ImageIcon(ImageIO.read(t_39));

            tile[39] = new Tile();
            assert t_40 != null;
            tile[39].image = new ImageIcon(ImageIO.read(t_40));

            tile[40] = new Tile();
            assert t_41 != null;
            tile[40].image = new ImageIcon(ImageIO.read(t_41));
            tile[40].collision = true;

            tile[41] = new Tile();
            assert t_42 != null;
            tile[41].image = new ImageIcon(ImageIO.read(t_42));
            tile[41].collision = true;




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

