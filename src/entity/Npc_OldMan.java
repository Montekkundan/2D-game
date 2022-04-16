package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.util.Random;

public class Npc_OldMan extends Entity{

    public Npc_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed =1;
        getNpcImage();
    }
    public void getNpcImage() {
        InputStream d_1 = getClass().getClassLoader().getResourceAsStream("res/npc/tile000.png");
        InputStream d_2 = getClass().getClassLoader().getResourceAsStream("res/npc/tile002.png");
        InputStream u_1 = getClass().getClassLoader().getResourceAsStream("res/npc/tile009.png");
        InputStream u_2 = getClass().getClassLoader().getResourceAsStream("res/npc/tile011.png");
        InputStream l_1 = getClass().getClassLoader().getResourceAsStream("res/npc/tile003.png");
        InputStream l_2 = getClass().getClassLoader().getResourceAsStream("res/npc/tile005.png");
        InputStream r_1 = getClass().getClassLoader().getResourceAsStream("res/npc/tile006.png");
        InputStream r_2 = getClass().getClassLoader().getResourceAsStream("res/npc/tile008.png");

        try{
            assert d_1 != null;
            down1 = new ImageIcon(ImageIO.read(d_1));
            assert d_2 != null;
            down2 = new ImageIcon(ImageIO.read(d_2));
            assert u_1 != null;
            up1 = new ImageIcon(ImageIO.read(u_1));
            assert u_2 != null;
            up2 = new ImageIcon(ImageIO.read(u_2));
            assert l_1 != null;
            left1 = new ImageIcon(ImageIO.read(l_1));
            assert l_2 != null;
            left2 = new ImageIcon(ImageIO.read(l_2));
            assert r_1 != null;
            right1 = new ImageIcon(ImageIO.read(r_1));
            assert r_2 != null;
            right2 = new ImageIcon(ImageIO.read(r_2));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setAction() {
        actionLockCounter++;
        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
}
