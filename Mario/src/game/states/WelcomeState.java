package game.states;

import game.GamePanel;
import game.utils.Resources;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by cerebro on 5/7/17.
 */
public class WelcomeState extends State{
    public static int selectorYCord=243;

    @Override
    public void render(Graphics a) {
        a.drawImage(Resources.welcomeImage,0,0,null);
        a.drawImage(Resources.selectorImage,330,selectorYCord,null);
    }
    public void onKeyDown(int keyCode) {
        if(keyCode== KeyEvent.VK_DOWN)
        {
            selectorYCord+=47;
            if(selectorYCord>290)
                selectorYCord=243;
            Resources.selectAudio.play();
        }
        else if(keyCode== KeyEvent.VK_UP)
        {
            selectorYCord-=47;
            if(selectorYCord<243)
                selectorYCord=290;
            Resources.selectAudio.play();

        }
        else if(keyCode == KeyEvent.VK_ENTER && selectorYCord==243)
        {
            GamePanel.currentState=new Stage1State();
            Resources.startAudio.play();
        }
        else if(keyCode == KeyEvent.VK_ENTER && selectorYCord==290)
        {
            Resources.startAudio.play();
            System.exit(0);
        }

    }
}
