package game;

import game.data.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 17/7/17.
 */
public class LoginScreen {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private JLabel error;
    private JButton signupButton;
    public JPanel myPanel;

    public static String email,password;

    public void loginScreen() {
        Game.setFrameLocation(400, 150);
        Dimension d = new Dimension(600, 250);
        myPanel.setPreferredSize(d);
        Game.addPanel(myPanel);
        Game.packPanel();


        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                error.setText(null);
                email=  LoginScreen.this.usernameField.getText();
                password=  LoginScreen.this.passwordField.getText();
                if(!Database.checkData(email,password))
                    error.setText("Username Or Password is Wrong !!!");
                else
                {
                    Game.removePanel(myPanel);
                    GamePanel game=new GamePanel();
                }

            }
        });

        this.signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1)
            {
                Game.removePanel(myPanel);
                Signup s=new Signup();
                s.signupPanel();

            }

        } );

    }
}
