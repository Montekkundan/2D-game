package main;

import entity.Npc_OldMan;
import monster.MON_Ghost;
import object.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }
    public void setObject(){
        int i = 0;
        gp.obj[i] = new Hearts(gp);
        gp.obj[i].worldX = gp.tileSize *21;
        gp.obj[i].worldY = gp.tileSize *19;
        i++;
        gp.obj[i] = new Key(gp);
        gp.obj[i].worldX = gp.tileSize *25;
        gp.obj[i].worldY = gp.tileSize *23;
        i++;
        gp.obj[i] = new Axe(gp);
        gp.obj[i].worldX = gp.tileSize *33;
        gp.obj[i].worldY = gp.tileSize *21;
        i++;
        gp.obj[i] = new Blue_shield(gp);
        gp.obj[i].worldX = gp.tileSize *35;
        gp.obj[i].worldY = gp.tileSize *21;
        i++;
        gp.obj[i] = new Potion_red(gp);
        gp.obj[i].worldX = gp.tileSize *22;
        gp.obj[i].worldY = gp.tileSize *27;
        i++;


    }
    public void setNpc(){
        gp.npc[0] = new Npc_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
    }
    public void setMonster(){
        int i = 0;
        gp.monster[i] = new MON_Ghost(gp);
        gp.monster[i].worldX = gp.tileSize*21;
        gp.monster[i].worldY = gp.tileSize*38;
        i++;
        gp.monster[i] = new MON_Ghost(gp);
        gp.monster[i].worldX = gp.tileSize*23;
        gp.monster[i].worldY = gp.tileSize*42;
        i++;
        gp.monster[i] = new MON_Ghost(gp);
        gp.monster[i].worldX = gp.tileSize*24;
        gp.monster[i].worldY = gp.tileSize*37;
        i++;
        gp.monster[i] = new MON_Ghost(gp);
        gp.monster[i].worldX = gp.tileSize*34;
        gp.monster[i].worldY = gp.tileSize*42;
        i++;
        gp.monster[i] = new MON_Ghost(gp);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*42;
        i++;

    }
}
