import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomePage extends JFrame {
    final private Font mainFont = new Font("celibrie", Font.BOLD, 18);
    JTextField tfFirstName ,tfLastName,tfEmail;
    JPasswordField pfpassword;


    public void SignIn() {

        /*********** Form**********************/

        JLabel LoginForm = new JLabel("Login form", SwingConstants.CENTER);
        LoginForm.setFont(mainFont);

        JLabel Email = new JLabel("Email");
        Email.setFont(mainFont);
        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel Password = new JLabel("Password");
        Password.setFont(mainFont);
        pfpassword = new JPasswordField();
        pfpassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.add(LoginForm);
        formPanel.add(Email);
        formPanel.add(tfEmail);
        formPanel.add(Password);
        formPanel.add(pfpassword);

        /******** Button ********/
        JButton Loginbtn = new JButton("Login");
        Loginbtn.setFont(mainFont);
        Loginbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // String email = tfEmail.getText();
                // String pass = String.valueOf(pfpassword.getPassword());
                // User user = getAuthenticatedUser(email, pass);

                // if (user != null) {
                // MainFrame mainframe = new Mainframe();
                // mainframe.initialize(user);
                // dispose();
                // }
                // else {
                // JOptionPane.showMessageDialog(HomePage.this, "Invalid Email or Password",
                // "Try agin",
                // JOptionPane.ERROR_MESSAGE);
                // }

            }

        });

        add(formPanel, BorderLayout.NORTH);

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void SignUp() {

        /*********** Form **********************/

        JLabel RegisterForm = new JLabel("SignUp", SwingConstants.CENTER);
        RegisterForm.setFont(mainFont);

        JLabel FirstName = new JLabel("First Name");
        FirstName.setFont(mainFont);
        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel LastName = new JLabel("Last Name");
        LastName.setFont(mainFont);
        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JLabel Email = new JLabel("Email");
        Email.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel Password = new JLabel("Password");
        Password.setFont(mainFont);

        pfpassword = new JPasswordField();
        pfpassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.add(RegisterForm);
        formPanel.add(FirstName);
        formPanel.add(tfFirstName);
        formPanel.add(LastName);
        formPanel.add(tfLastName);
        formPanel.add(Email);
        formPanel.add(tfEmail);
        formPanel.add(Password);
        formPanel.add(pfpassword);

        /******** Button ********/
        JButton Loginbtn = new JButton("Login");
        Loginbtn.setFont(mainFont);
        Loginbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // String email = tfEmail.getText();
                // String pass = String.valueOf(pfpassword.getPassword());
                // User user = getAuthenticatedUser(email, pass);

                // if (user != null) {
                // MainFrame mainframe = new Mainframe();
                // mainframe.initialize(user);
                // dispose();
                // }
                // else {
                // JOptionPane.showMessageDialog(HomePage.this, "Invalid Email or Password",
                // "Try agin",
                // JOptionPane.ERROR_MESSAGE);
                // }

            }

        });

        add(formPanel, BorderLayout.NORTH);

        setTitle("Sign Up Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        HomePage obj = new HomePage();
        obj.SignUp();
        // obj.SignIn();
    }
}
