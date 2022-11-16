package project_test_methods;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {

    Car car = new Car();

    JFrame frame = new JFrame();
    JLabel welcomeL  = new JLabel("");


    WelcomePage( String userID)  {//String userID  // Car carByID

        welcomeL.setBounds(0,0,250,35);
        welcomeL.setFont(new Font(null,Font.ITALIC,25));
        welcomeL.setText("Hello "+userID +'\n'+" Welcome in !");



        frame.add(welcomeL);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        //frame.setLayout(null);
        frame.setVisible(true);
    }
}
