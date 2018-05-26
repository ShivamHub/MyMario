package game.states;

import game.data.Database;
import game.LoginScreen;
import game.Game;
import game.GamePanel;
import game.utils.Resources;

import java.awt.*;

/**
 * Created by cerebro on 5/7/17.
 */
public class GameOverState extends State {
    private static int previousHighscore;
    private static boolean showScoreBoard=false;

    public GameOverState() {
        previousHighscore=GameOverState.database();
    }
    @Override
    public void render(Graphics a) {
        a.setColor(Stage1State.SKY_BLUE_COLOR);
     a.fillRect(0,0, GamePanel.WIDTH,GamePanel.HEIGHT);
     a.drawImage(Resources.gameoverImage,5,10,null);
        Color c=new Color(0x3C3B37);
        a.setColor(c);
        a.setFont(new Font("Aerial", Font.BOLD, 24));
        a.drawString("Your Score : "+Stage1State.score, 50, 310);
        a.drawString("Your Previous HighScore : "+previousHighscore, 50, 350);
        a.drawImage(Resources.playagainImage,60,380,null);
        a.drawImage(Resources.highscoresImage,280,380,null);
        GameOverState.highscore(a);
        if(showScoreBoard)
            GameOverState.scoreBoard(a);

    }

    @Override
    public void onClick(int x, int y) {
       if(x>60 && x<=255 && y>380 && y<=430 &&!showScoreBoard)
           GamePanel.currentState=new Stage1State();
       else if(x>280 && x<=470 && y>380 && y<=430 && !showScoreBoard)
           showScoreBoard=true;
       else if(x>70 && x<=139 && y>350 &&y<=419 && showScoreBoard )
           showScoreBoard=false;

    }
    public static int database()
    {
       return Database.searchEmail(LoginScreen.email);

    }
    public static void highscore(Graphics a)
    {
     if(Stage1State.score >previousHighscore )
     {
         a.drawImage(Resources.congratulationImage,400,50,null);
         Color c=new Color(0xEA4335);
         a.setColor(c);
         a.setFont(new Font("ARIAl", Font.BOLD, 30));
         a.drawString(" YOU BROKE YOUR  ", 470, 300);
         a.drawString("OWN HIGH SCORE   ", 470, 330);
         Database.updateHighscore(LoginScreen.email,Stage1State.score);
     }
    }
    public static void scoreBoard(Graphics a)
    {    Database.sortScore();
        a.setColor(Color.black);
        a.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);
        a.setColor(Color.yellow);
        a.setFont(new Font("FIRA CODE", Font.BOLD, 50));
        a.drawString("HIGH",230,70);
        a.drawString("SCORE",380,70);
        a.setColor(Color.GREEN);
        a.setFont(new Font("FIRA CODE", Font.BOLD, 20));
        a.drawString("RANK",195,130);
        a.drawString("NAME",350,130);
        a.drawString("HIGH SCORE",500,130);
        a.setColor(Color.RED);
        a.drawString("1 ST",200,180);
        a.drawString("2 ND",200,220);
        a.drawString("3 RD",200,260);
        a.drawString("4 TH",200,300);
        a.drawString("5 TH",200,340);
        for(int i=0;i<5;i++){
            a.drawString(Database.name.get(i),350,180+(40*i));
            a.drawString(Database.highscore.get(i)+"",550,180+(40*i));
        }
        a.drawImage(Resources.backButton,70,350,null);

    }
}
