import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class SignIn extends JFrame {
    final private Font mainFont = new Font("", Font.BOLD, 18);

    JTextField tfFirstName, tfLastName, tfEmail;
    JPasswordField pfpassword;

    public void Login() {

        /*********** Form **********************/

        JLabel LoginForm = new JLabel("Login form", SwingConstants.CENTER);
        LoginForm.setFont(mainFont);
        LoginForm.setVisible(true);
        add(LoginForm);

        JPanel lPanel = new JPanel();
        lPanel.setBounds(100, 100, 350, 450);
        lPanel.setBackground(Color.LIGHT_GRAY);

        JLabel Email = new JLabel("Email");
        Email.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setBounds(10, 50, 1000, 30);
        tfEmail.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = "^(.+)@(.+)$";
                String str = tfEmail.getText();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches() == false) {
                    JOptionPane.showMessageDialog(null, "Invalid Email",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }

        });

        JLabel Password = new JLabel("Password");
        Password.setFont(mainFont);
        pfpassword = new JPasswordField();
        pfpassword.setBounds(10, 90, 1000, 30);

        pfpassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = String.valueOf(pfpassword.getPassword());
                if (pass.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password contain at least 8 character",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        /******** Button ********/
        JButton Login = new JButton("Login");
        Login.setBounds(100, 120, 100, 20);

        JButton SignUp = new JButton("Sign Up");
        SignUp.setBounds(100, 145, 100, 20);

        lPanel.add(Email);
        lPanel.add(tfEmail);
        lPanel.add(Password);
        lPanel.add(pfpassword);
        lPanel.add(Login);
        lPanel.add(SignUp);

        SignUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Signup obj = new Signup();
                obj.setVisible(true);
                obj.Registration();

            }

        });

        Login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Lemail = tfEmail.getText();
                String Lpass = String.valueOf(pfpassword.getPassword());

                Database Dob = new Database();
                Dob.varification(Lemail, Lpass);
                setVisible(false);
            }

        });
        add(lPanel);

        setTitle("Login");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SignIn obj = new SignIn();
        obj.Login();
    }
}
