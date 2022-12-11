import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class SignIn extends JFrame {
    final private Font mainFont = new Font("Ariel", Font.BOLD, 18);

    JTextField tfFirstName, tfLastName, tfEmail;
    JPasswordField pfpassword;

    public void Login() {

        JLabel LoginForm = new JLabel("Login Form",SwingConstants.CENTER);
        LoginForm.setFont(mainFont);
        add(LoginForm);



        /*********** Create a Login Form **********************/

          JLabel Email = new JLabel("Email");
          Email.setFont(mainFont);

          tfEmail = new JTextField();
          tfEmail.setFont(mainFont);
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
         pfpassword.setFont(mainFont);

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

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        
        formPanel.add(LoginForm);
        formPanel.add(Email);
        formPanel.add(tfEmail);
        formPanel.add(Password);
        formPanel.add(pfpassword);
        add(formPanel, BorderLayout.NORTH);


        /******** Create  Button ********/
        JButton Login = new JButton("Login");
        Login.setFont(mainFont);

        JButton SignUp = new JButton("Sign Up");
        SignUp.setFont(mainFont);
       

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
                Database dbobj = new Database();
                dbobj.receivemail(Lemail);
                // row = dbobj.receivemail(email);
                setVisible(false);
            }

        });

        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new GridLayout(1, 2, 10, 0));
        btnpanel.add(Login);
        btnpanel.add(SignUp);
        add(btnpanel, BorderLayout.SOUTH);
        

        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350,450));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SignIn obj = new SignIn();
        obj.Login();
    }
}
