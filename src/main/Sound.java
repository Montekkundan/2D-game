package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    public Sound(){
        soundURL[0] = getClass().getClassLoader().getResource("res/sound/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getClassLoader().getResource("res/sound/coin.wav");
        soundURL[2] = getClass().getClassLoader().getResource("res/sound/fanfare.wav");
        soundURL[3] = getClass().getClassLoader().getResource("res/sound/powerup.wav");
        soundURL[4] = getClass().getClassLoader().getResource("res/sound/unlock.wav");
        soundURL[5] = getClass().getClassLoader().getResource("res/sound/hitmonster.wav");
        soundURL[6] = getClass().getClassLoader().getResource("res/sound/receivedamage.wav");
        soundURL[7] = getClass().getClassLoader().getResource("res/sound/swingweapon.wav");
        soundURL[8] = getClass().getClassLoader().getResource("res/sound/levelup.wav");
        soundURL[9] = getClass().getClassLoader().getResource("res/sound/cursor.wav");

    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
