package game;

import game.data.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 17/7/17.
 */
public class Signup {
    private JTextField nameField;
    private JTextField dobField;
    private JTextField mobileField;
    private JTextField emailField;
    private JTextField passwordField;
    private JLabel emailError;
    private JLabel passwordError;
    private JLabel successful;
    private JButton submitButton;
    private JButton backButton;
    public JPanel myPanel1;

    public  static String name,dob,mobile,email,password;

    public void signupPanel()
    {
        Game.addPanel(myPanel1);
        Game.setFrameLocation(400,190);


        myPanel1.setPreferredSize(new Dimension(700,380));
        Game.packPanel();

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Signup.this.emailError.setText(null);
                Signup.this.passwordError.setText(null);
                name = Signup.this.nameField.getText();
                dob = Signup.this.dobField.getText();
                mobile = Signup.this.mobileField.getText();
                email = Signup.this.emailField.getText();
                if(Database.checkEmail(email))
                {
                    Signup.this.emailError.setText("( Email Id Already Exist )");
                }
                password = Signup.this.passwordField.getText();
                if (password.length() < 6) {
                    Signup.this.passwordError.setText("( Password is too small )");
                }
                else
                {
                    Database.add(name, dob, mobile, email, password);
                    successful.setText("( Successful )");
                }
            }

        });

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.removePanel(myPanel1);
                LoginScreen l=new LoginScreen();
                l.loginScreen();
            }
        });

    }

}
