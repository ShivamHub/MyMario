package game.entities;

import game.utils.Mute;
import game.utils.Resources;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 28/06/17.
 */
public class Player extends Entity {

    private static final int GROUND_Y = 315;
    private List<Image> images;
    private int currentIndex = 0;
    private int ducked = 0;

    public Player() {

        super(72, 90);

        this.x = 400;
        this.y = GROUND_Y;

        images = new ArrayList<>();

        images.add(Resources.playerImage1);
        images.add(Resources.playerImage2);
        images.add(Resources.playerImage3);
        images.add(Resources.playerImage4);
        images.add(Resources.playerImage5);
        images.add(Resources.playerImage4);
        images.add(Resources.playerImage3);
        images.add(Resources.playerImage2);
    }

    @Override
    public void update() {
        super.update();

        currentIndex++;
        currentIndex %= 8;

        if(this.y >= GROUND_Y) {
            this.y = GROUND_Y;
            this.yVel = 0;
            this.yAcc = 0;
        }

        if(ducked > 0) {
            ducked--;
        }
    }

    public void jump() {
        if(this.y == GROUND_Y) {
            this.yVel = -20;
            this.yAcc = 1;
            Mute.checkMuteJump();
            this.ducked = 0;
        }
    }

    public void duck() {
        if(ducked == 0) {
            ducked = 30;
        }
    }

    @Override
    public Image getImage() {
        if(ducked > 0) {
            return Resources.playerDuckImage;
        } else if (this.y < GROUND_Y) {
            return Resources.playerJumpImage;
        } else {
            return images.get(currentIndex);
        }
    }

    @Override
    public void setRectBounds() {
        if(ducked > 0) {
            this.rect.setBounds(this.x, this.y + 20, 72, 70);
        } else {
            super.setRectBounds();
        }
    }
}
