package game.entities;

import game.utils.Resources;

import java.awt.*;

/**
 * Created by cerebro on 28/06/17.
 */
public class Block extends Entity {

    public Block(int x, int y) {

        super(20, 50);

        this.x = x;
        this.y = y;
        this.xVel = -5;
    }

    @Override
    public Image getImage() {
        return Resources.blockImage;
    }
}
