package game.states;

import game.Game;
import game.GamePanel;
import game.entities.*;
import game.utils.Mute;
import game.utils.RandomGenerator;
import game.utils.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 27/06/17.
 */
public class Stage1State extends State {
    public static int score;
    private static final int GRASS_HEIGHT = 45;

    private static final int GRASS_Y_CORD = GamePanel.HEIGHT - GRASS_HEIGHT;
    public static final Color SKY_BLUE_COLOR = new Color(161, 204, 255);
    private static final Font MY_FONT = new Font("Aerial", Font.BOLD, 24);
    private static final int GROUND_Y = 355;
    private static final int AIR_Y = 275;
    private Player player;

    private List<Block> blocks = new ArrayList<>();

    public Stage1State() {
        score=0;
        player = new Player();

        blocks.add(new Block(900, getRandomBlockY()));
        blocks.add(new Block(1100, getRandomBlockY()));
        blocks.add(new Block(1300, getRandomBlockY()));
        blocks.add(new Block(1500, getRandomBlockY()));
        blocks.add(new Block(1700, getRandomBlockY()));

        entities.addAll(blocks);
        entities.add(new Cloud(600));
        entities.add(new Cloud(900));
        entities.add(player);
    }

    private int getRandomBlockY() {
        if (RandomGenerator.randomInt(2) == 0) {
            return GROUND_Y;
        } else {
            return AIR_Y;
        }
    }

    @Override
    public void update() {
        super.update();
        score++;

        for (Block b : blocks) {
            if (player.isCollidingWith(b)) {
                player.x -= 50;
                Mute.checkMuteHit();
                b.visible = false;
            }
            if(player.x<=-10)
                GamePanel.currentState=new GameOverState();

            if (b.x < -20) {
                b.x = 980;
                b.visible = true;

                b.y = getRandomBlockY();
            }
        }
    }

    @Override
    public void render(Graphics a) {
        a.setColor(SKY_BLUE_COLOR);
        a.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        a.drawImage(Resources.grassImage, 0, GRASS_Y_CORD, null);
        a.drawImage(Resources.sunImage, 0, 0, null);
        a.setColor(Color.black);
        a.fillRect(0,300,2,107);

        for (Entity e : entities) {
            if (e.visible) {
                a.drawImage(e.getImage(), e.x, e.y, null);
            }
        }
        Mute.drawImage(a);
        Color c=new Color(0x38A852);
        a.setColor(c);
        a.setFont(MY_FONT);
        a.drawString("Score : "+score, 300, 40);

    }

    @Override
    public void onKeyDown(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {
            player.jump();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            player.duck();
        } else if(keyCode == KeyEvent.VK_ESCAPE) {
            GamePanel.pause = !GamePanel.pause;

        }
    }

    @Override
    public void onClick(int x, int y) {
     if(x>710 && x<=761 && y>20 &&y<=60)
         Mute.changeMute();
    }
}
