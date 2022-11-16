package project_test_methods;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static project_test_methods.Main.getCarByID;

public class LoginPage implements ActionListener {

    // componente precum etichetele, butoanele,
    // câmpurile de text sunt adăugate pentru a crea o interfață grafică.
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");// buton de logare
    JButton resetButton = new JButton("Reset"); //resetButton

    //Obiectul unei clase JTextField este o componentă de text
    // care permite editarea unui text cu o singură linie. Moștenește clasa JTextComponent.
    JTextField userIdField = new JTextField();


    //Obiectul unei clase JPasswordField este o componentă de text specializată pentru introducerea parolei.
    // Permite editarea unei singure linii de text. Moștenește clasa JTextField.
    JPasswordField userPassWord = new JPasswordField();


    //acum am o copie a HshMapului
    // care este globally available -
    //O variabilă globală este una declarată la începutul
    // codului și este accesibilă tuturor părților programului
    HashMap<String, String> logininfo = new HashMap<String, String>();

    // Este folosit pentru a afișa o singură linie de text numai pentru citire.
    // ce este foarte interesant ? ca userul nu poate modifica ci doar o alta app.
    // mosteneste JComponenet...
    JLabel userIdLabel = new JLabel("userID");
    JLabel passwordLabel = new JLabel("password");
    JLabel messageLabel = new JLabel("Login Page");
    //vreau sa mi afiseze mesaj daca e ok sau nu logarea
    // pentru asta folosesc iar un JLabel

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;
        // adaugam  componentele  - user  and pass labels -  exit and reset  ;

        userIdLabel.setBounds(50, 100, 75, 25);
        passwordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.BOLD, 25));

        //creez campurile pentru user si pass. unde scrie de la tast.
        userIdField.setBounds(125, 100, 200, 25);
        userPassWord.setBounds(125, 150, 200, 25);

        //trebuie sa facem buton de logare
        loginButton.setBounds(125, 200, 100, 25);
        // loginButton.setFocusable(false);
        loginButton.addActionListener(this); // AL va reacctiona

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.addActionListener(this); // AL va reacctiona


        // tot ce facem  deasupra,  le adaug cu frame.add
        // le adaugam sa fie vizibile.

        frame.add(userIdLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPassWord);
        frame.add(loginButton);
        frame.add(resetButton);
        // se va inchide cand dam exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(420, 420);
        frame.setLayout(null);
        // vrem sa fie vizibil
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIdField.setText("");
            userPassWord.setText("");
        }

        if (e.getSource() == loginButton) {
            String userID = userIdField.getText();
            String passW =  String.valueOf(userPassWord.getPassword());
            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(passW)){
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful!");
                    WelcomePage welcomePage =new WelcomePage(userID);  //getCarByID
                }
                else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Try again!");
                }
            }
            else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Try again!");
            }
        }
    }
}



