package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, rightPressed, leftPressed, spacePressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //TitleState
        if(gp.gameState == gp.titleState){
        titleState(code);
        }

        //PlayState
        else if(gp.gameState == gp.playState) {
        playState(code);
        }
        //PauseState
        else if(gp.gameState == gp.pauseState){
        pauseState(code);
        }
        //DialogueState
        else if(gp.gameState == gp.dialogueState){
        dialogueState(code);
        }
        //CharacterState
        else if(gp.gameState == gp.characterState){
        characterState(code);
        }
    }
    public void titleState(int code){
        if(gp.ui.titleScreenState == 0) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNumber--;
                if (gp.ui.commandNumber < 0) {
                    gp.ui.commandNumber = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNumber++;
                if (gp.ui.commandNumber > 2) {
                    gp.ui.commandNumber = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.commandNumber == 0) {
                    gp.ui.titleScreenState = 1;
                }
                if (gp.ui.commandNumber == 1) {

                }
                if (gp.ui.commandNumber == 2) {
                    System.exit(0);
                }
            }
        }
        else if(gp.ui.titleScreenState == 1) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNumber--;
                if (gp.ui.commandNumber < 0) {
                    gp.ui.commandNumber = 4;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNumber++;
                if (gp.ui.commandNumber > 4) {
                    gp.ui.commandNumber = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.commandNumber == 0) {
                    gp.player.playerSelector = 0;
                    gp.gameState = gp.playState;
                    gp.playMusic(0);

                }
                if (gp.ui.commandNumber == 1) {
                    gp.player.playerSelector = 0;
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNumber == 2) {
                    gp.player.playerSelector = 0;
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNumber == 3) {
                    gp.player.playerSelector = 0;
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNumber == 4) {
                    gp.ui.commandNumber = 0;
                    gp.ui.titleScreenState = 0;
                }
            }
        }
    }
    public void playState(int code){
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_P) {
            gp.gameState = gp.pauseState;
        }
        if(code == KeyEvent.VK_C){
            gp.gameState = gp.characterState;
        }
        if (code == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }
    }
    public void pauseState(int code){
        if (code == KeyEvent.VK_P){
            gp.gameState = gp.playState;
        }
    }
    public void dialogueState(int code){
        if (code == KeyEvent.VK_SPACE){
            gp.gameState = gp.playState;
        }
    }
    public void characterState(int code){
        if(code == KeyEvent.VK_C){
            gp.gameState = gp.playState;
        }
        if (code == KeyEvent.VK_W) {
            if(gp.ui.slotRow != 0) {
                gp.ui.slotRow--;
                gp.playSoundEffect(9);
            }
        }
        if (code == KeyEvent.VK_A) {
            if(gp.ui.slotCol !=0) {
                gp.ui.slotCol--;
                gp.playSoundEffect(9);
            }

        }
        if (code == KeyEvent.VK_S) {
            if(gp.ui.slotRow !=3) {
                gp.ui.slotRow++;
                gp.playSoundEffect(9);
            }

        }
        if (code == KeyEvent.VK_D) {
            if(gp.ui.slotCol != 4) {
                gp.ui.slotCol++;
                gp.playSoundEffect(9);
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_P){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_C){
            spacePressed = false;
        }
    }
}
