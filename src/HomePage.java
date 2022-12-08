import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class HomePage extends JFrame {
    final private Font mainFont = new Font("", Font.BOLD, 18);

    JTextField tfFirstName ,tfLastName,tfEmail;
    JPasswordField pfpassword;


    public void SignUp() {

        /*********** Form **********************/

        JLabel RegisterForm = new JLabel("SignUp", SwingConstants.CENTER);

        JLabel FirstName = new JLabel("First Name");
        FirstName.setFont(mainFont);
        tfFirstName = new JTextField();
        tfFirstName.setBounds(60, 60, 50, 60);

        JLabel LastName = new JLabel("Last Name");
        LastName.setFont(mainFont);
        tfLastName = new JTextField();

        JLabel Email = new JLabel("Email");
        Email.setFont(mainFont);
        tfEmail = new JTextField();

        JLabel Password = new JLabel("Password");
        Password.setFont(mainFont);
        pfpassword = new JPasswordField();

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
        JButton Loginbtn = new JButton("Creat Account");
        Loginbtn.setBounds(50, 20, 50, 40);

        JButton back = new JButton("Back");
        back.setBounds(50, 20, 50, 40);

        formPanel.add(Loginbtn);
        formPanel.add(back);

        Loginbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Fname = tfFirstName.getText();
                String Lname = tfLastName.getText();
                String email = tfEmail.getText();
                String pass = String.valueOf(pfpassword.getPassword());

                Boolean Pflag = PasswordValidation(pass);
                boolean Eflag = EmailValidation(email);

                if (Fname.length() == 0 || Lname.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Name filed cann't blank",
                            "warning", JOptionPane.WARNING_MESSAGE);
                }

                if (Pflag && Eflag && Fname.length() > 0 && Lname.length() > 0) {
                    Database db = new Database();
                    db.SetData(Fname, Lname, email, pass);

                }
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

    public boolean PasswordValidation(String pass) {
        if (pass.length() >= 8)
            return true;
        else {
            JOptionPane.showMessageDialog(null, "Password contain at least 8 character",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean EmailValidation(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == false) {
            JOptionPane.showMessageDialog(null, "Invalid Email",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return matcher.matches();
    }






    public void SignIn() {

        /*********** Form **********************/

        JLabel LoginForm = new JLabel("Login form", SwingConstants.CENTER);
        LoginForm.setFont(mainFont);

        JLabel Email = new JLabel("Email");
        Email.setFont(mainFont);
    tfEmail = new JTextField();


    JLabel Password = new JLabel("Password");
    Password.setFont(mainFont);
    pfpassword = new JPasswordField();


    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(0, 1, 10, 10));
    formPanel.add(LoginForm);
    formPanel.add(Email);
    formPanel.add(tfEmail);
    formPanel.add(Password);
    formPanel.add(pfpassword);

    /******** Button ********/
    JButton Login = new JButton("Login");

    JButton SignUp = new JButton("Sign Up");

    formPanel.add(Login);
    formPanel.add(SignUp);

    SignUp.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            setVisible(false);
            SignUp();

        }

    });

    Login.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String Lemail = tfEmail.getText();
            String Lpass = String.valueOf(pfpassword.getPassword());

            Database Dob = new Database();
            Dob.varification(Lemail, Lpass);
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
}
