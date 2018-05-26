package game;

import javax.swing.*;

/**
 * Created by cerebro on 27/06/17.
 */
public class Game {

    private static JFrame frame;

    public static void main(String[] args) {
        frame=new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Mario...");
        LoginScreen l=new LoginScreen();
        l.loginScreen();
        frame.setVisible(true);

    }
    public static void setFrameLocation(int x,int y)
    {
        frame.setLocation(x,y);
    }
    public static void packPanel()
    {
        frame.pack();
    }
    public static void addPanel(JPanel p)
    {
        frame.add(p);
    }
    public static void removePanel(JPanel p)
    {
        frame.remove(p);
    }


}
