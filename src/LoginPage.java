import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo;

    public LoginPage(HashMap<String, String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;

        // Layout
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);
        loginButton.setBounds(125, 200, 100, 25);
        resetButton.setBounds(225, 200, 100, 25);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        } else if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID) && logininfo.get(userID).equals(password)) {
                frame.dispose();
                new WelcomePage(userID);
            } else {
                messageLabel.setText("Invalid credentials");
            }
        }
    }
}