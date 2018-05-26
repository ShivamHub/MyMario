package game.utils;

import game.Game;
import game.GamePanel;

import java.awt.*;

/**
 * Created by cerebro on 5/7/17.
 */
public class Mute{
    public static boolean mute = false;

    public static void changeMute() {
        mute = !mute;

    }
    public static void checkMuteHit() {
        if(!mute)
        {
            Resources.hitAudio.play();
        }
    }
    public static void checkMuteJump() {
        if(!mute)
        {
            Resources.jumpAudio.play();
        }
    }

    public static void drawImage(Graphics a) {
        if(mute)
            a.drawImage(Resources.unmuteButtonImage, GamePanel.WIDTH-70,20,null);
        else
            a.drawImage(Resources.muteButtonImage, GamePanel.WIDTH-70,20,null);
    }
}