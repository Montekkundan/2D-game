package main;

import entity.Npc_OldMan;
import monster.MON_Ghost;
import object.*;
import tile_interactive.DryTree;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }
    public void setObject(){
        int mapNum =0;
        int i = 0;
        gp.obj[mapNum][i] = new Hearts(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *21;
        gp.obj[mapNum][i].worldY = gp.tileSize *19;
        i++;
        gp.obj[mapNum][i] = new Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *25;
        gp.obj[mapNum][i].worldY = gp.tileSize *23;
        i++;
        gp.obj[mapNum][i] = new Axe(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *33;
        gp.obj[mapNum][i].worldY = gp.tileSize *21;
        i++;
        gp.obj[mapNum][i] = new Blue_shield(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *35;
        gp.obj[mapNum][i].worldY = gp.tileSize *21;
        i++;
        gp.obj[mapNum][i] = new Potion_red(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *22;
        gp.obj[mapNum][i].worldY = gp.tileSize *27;
        i++;

        // house
        mapNum = 1;
        gp.obj[mapNum][i] = new Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *15;
        gp.obj[mapNum][i].worldY = gp.tileSize *20;
        i++;
        // bookcase
        gp.obj[mapNum][i] = new bookcase(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *8;
        gp.obj[mapNum][i].worldY = gp.tileSize *17;
        i++;
        gp.obj[mapNum][i] = new bookcase(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *9;
        gp.obj[mapNum][i].worldY = gp.tileSize *15;
        i++;
        gp.obj[mapNum][i] = new bookcase(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *13;
        gp.obj[mapNum][i].worldY = gp.tileSize *7;
        i++;
        gp.obj[mapNum][i] = new bookcase(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *16;
        gp.obj[mapNum][i].worldY = gp.tileSize *8;
        i++;
        gp.obj[mapNum][i] = new bookcase(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *18;
        gp.obj[mapNum][i].worldY = gp.tileSize *15;
        i++;
        // cupboard
        gp.obj[mapNum][i] = new cupboard(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *10;
        gp.obj[mapNum][i].worldY = gp.tileSize *7;
        i++;
        gp.obj[mapNum][i] = new cupboard(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *17;
        gp.obj[mapNum][i].worldY = gp.tileSize *7;
        i++;
        //carpet
        gp.obj[mapNum][i] = new carpet(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *15;
        gp.obj[mapNum][i].worldY = gp.tileSize *19;
        i++;
        gp.obj[mapNum][i] = new carpet(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *17;
        gp.obj[mapNum][i].worldY = gp.tileSize *14;
        i++;
        gp.obj[mapNum][i] = new carpet(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *17;
        gp.obj[mapNum][i].worldY = gp.tileSize *12;
        i++;
        //plant
        gp.obj[mapNum][i] = new plant(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *13;
        gp.obj[mapNum][i].worldY = gp.tileSize *19;
        i++;
        gp.obj[mapNum][i] = new plant(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *13;
        gp.obj[mapNum][i].worldY = gp.tileSize *13;
        i++;
        gp.obj[mapNum][i] = new plant(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *9;
        gp.obj[mapNum][i].worldY = gp.tileSize *13;
        i++;
        gp.obj[mapNum][i] = new plant(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *16;
        gp.obj[mapNum][i].worldY = gp.tileSize *11;
        i++;
        gp.obj[mapNum][i] = new plant(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *17;
        gp.obj[mapNum][i].worldY = gp.tileSize *19;
        i++;
        gp.obj[mapNum][i] = new plant(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *18;
        gp.obj[mapNum][i].worldY = gp.tileSize *18;
        i++;
        // chair
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *10;
        gp.obj[mapNum][i].worldY = gp.tileSize *19;
        i++;
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *9;
        gp.obj[mapNum][i].worldY = gp.tileSize *9;
        i++;
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *11;
        gp.obj[mapNum][i].worldY = gp.tileSize *8;
        i++;
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *16;
        gp.obj[mapNum][i].worldY = gp.tileSize *16;
        i++;
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *9;
        gp.obj[mapNum][i].worldY = gp.tileSize *18;
        i++;
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *17;
        gp.obj[mapNum][i].worldY = gp.tileSize *15;
        i++;
        gp.obj[mapNum][i] = new chair(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *15;
        gp.obj[mapNum][i].worldY = gp.tileSize *15;
        i++;
        //desk
        gp.obj[mapNum][i] = new desk(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *19;
        gp.obj[mapNum][i].worldY = gp.tileSize *8;
        i++;
        // table
        gp.obj[mapNum][i] = new table(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *9;
        gp.obj[mapNum][i].worldY = gp.tileSize *19;
        i++;
        gp.obj[mapNum][i] = new table(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *10;
        gp.obj[mapNum][i].worldY = gp.tileSize *8;
        i++;
        gp.obj[mapNum][i] = new table(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *16;
        gp.obj[mapNum][i].worldY = gp.tileSize *15;
        i++;
        //toilet
        gp.obj[mapNum][i] = new toilet(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *18;
        gp.obj[mapNum][i].worldY = gp.tileSize *7;
        i++;
        // bed
        gp.obj[mapNum][i] = new bed(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize *11;
        gp.obj[mapNum][i].worldY = gp.tileSize *10;
        i++;

    }
    public void setNpc(){
        int mapNum =0;
        int i =0;
        gp.npc[mapNum][i] = new Npc_OldMan(gp);
        gp.npc[mapNum][i].worldX = gp.tileSize*21;
        gp.npc[mapNum][i].worldY = gp.tileSize*21;
        i++;
    }
    public void setMonster(){
        int mapNum =0;
        int i = 0;
        gp.monster[mapNum][i] = new MON_Ghost(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*21;
        gp.monster[mapNum][i].worldY = gp.tileSize*38;
        i++;
        gp.monster[mapNum][i] = new MON_Ghost(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_Ghost(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*24;
        gp.monster[mapNum][i].worldY = gp.tileSize*37;
        i++;
        gp.monster[mapNum][i] = new MON_Ghost(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*34;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_Ghost(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
    }
    public void setInteractiveTile(){
        int mapNum =0;
        int i = 0;
        gp.iTile[mapNum][i]= new DryTree(gp,27,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,28,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,29,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,30,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,31,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,32,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,33,12);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,21,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,20,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,19,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,18,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,17,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,16,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,15,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,14,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,13,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,12,13);i++;
        gp.iTile[mapNum][i]= new DryTree(gp,11,13);i++;



    }
}
