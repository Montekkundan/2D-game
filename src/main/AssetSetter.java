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
