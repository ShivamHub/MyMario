package game.utils;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;

/**
 * Created by cerebro on 28/06/17.
 */
public class Resources {
    public static Image grassImage;
    public static Image playerImage1;
    public static Image playerImage2;
    public static Image playerImage3;
    public static Image playerImage4;
    public static Image playerImage5;
    public static Image playerDuckImage;
    public static Image playerJumpImage;
    public static Image blockImage;
    public static Image cloudImage1;
    public static Image cloudImage2;
    public static Image welcomeImage;
    public static Image selectorImage;
    public static Image sunImage;
    public static Image muteButtonImage;
    public static Image unmuteButtonImage;
    public static Image gameoverImage;
    public static Image playagainImage;
    public static Image highscoresImage;
    public static Image congratulationImage;
    public static Image backButton;

    public static AudioClip jumpAudio;
    public static AudioClip hitAudio;
    public static AudioClip startAudio;
    public static AudioClip selectAudio;


    public static void load() {
        try {
            Resources.grassImage = ImageIO.read(Resources.class.getResource("../resources/grass.png"));
            Resources.blockImage = ImageIO.read(Resources.class.getResource("../resources/block.png"));
            Resources.cloudImage1 = ImageIO.read(Resources.class.getResource("../resources/cloud1.png"));
            Resources.cloudImage2 = ImageIO.read(Resources.class.getResource("../resources/cloud2.png"));
            Resources.playerImage1 = ImageIO.read(Resources.class.getResource("../resources/run_anim1.png"));
            Resources.playerImage2 = ImageIO.read(Resources.class.getResource("../resources/run_anim2.png"));
            Resources.playerImage3 = ImageIO.read(Resources.class.getResource("../resources/run_anim3.png"));
            Resources.playerImage4 = ImageIO.read(Resources.class.getResource("../resources/run_anim4.png"));
            Resources.playerImage5 = ImageIO.read(Resources.class.getResource("../resources/run_anim5.png"));
            Resources.playerJumpImage = ImageIO.read(Resources.class.getResource("../resources/jump.png"));
            Resources.playerDuckImage = ImageIO.read(Resources.class.getResource("../resources/duck.png"));
            Resources.welcomeImage = ImageIO.read(Resources.class.getResource("../resources/welcome.png"));
            Resources.selectorImage = ImageIO.read(Resources.class.getResource("../resources/selector.png"));
            Resources.sunImage = ImageIO.read(Resources.class.getResource("../resources/sun.png"));
            Resources.muteButtonImage = ImageIO.read(Resources.class.getResource("../resources/muteButton.png"));
            Resources.unmuteButtonImage = ImageIO.read(Resources.class.getResource("../resources/unmuteButton.png"));
            Resources.gameoverImage = ImageIO.read(Resources.class.getResource("../resources/gameover.png"));
            Resources.playagainImage = ImageIO.read(Resources.class.getResource("../resources/playagain.png"));
            Resources.highscoresImage = ImageIO.read(Resources.class.getResource("../resources/highscores.png"));
            Resources.congratulationImage= ImageIO.read(Resources.class.getResource("../resources/congratulation.png"));
            Resources.backButton= ImageIO.read(Resources.class.getResource("../resources/back.png"));

            Resources.jumpAudio = Applet.newAudioClip(Resources.class.getResource("../resources/onjump.wav"));
            Resources.hitAudio = Applet.newAudioClip(Resources.class.getResource("../resources/hit.wav"));
            Resources.startAudio = Applet.newAudioClip(Resources.class.getResource("../resources/start.wav"));
            Resources.selectAudio = Applet.newAudioClip(Resources.class.getResource("../resources/changeOption.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
