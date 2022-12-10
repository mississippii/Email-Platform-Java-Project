import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Signup extends JFrame {
    final private Font mainFont = new Font("", Font.BOLD, 18);

    JTextField tfFirstName, tfLastName, tfEmail;
    JPasswordField pfpassword;

    public void Registration() {

        /*********** Form **********************/
        SignIn Hobj = new SignIn();
        Hobj.setVisible(false);

        JLabel RegisterForm = new JLabel("SignUp", SwingConstants.CENTER); // title

        JLabel FirstName = new JLabel("First Name");
        FirstName.setFont(mainFont);
        tfFirstName = new JTextField();
        tfFirstName.setBounds(100, 100, 150, 40);
        tfFirstName.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String str = tfFirstName.getText();
                if (!str.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Name contain only english latter", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        JLabel LastName = new JLabel("Last Name");
        LastName.setFont(mainFont);
        tfLastName = new JTextField();
        tfLastName.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String str = tfFirstName.getText();
                if (!str.matches("[a-z jA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Name contain only english latter", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        JLabel Email = new JLabel("Email");
        Email.setFont(mainFont);
        tfEmail = new JTextField();
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
        JButton signup = new JButton("Creat Account");
        signup.setBounds(50, 20, 50, 40);

        JButton back = new JButton("Back");
        back.setBounds(50, 20, 50, 40);

        formPanel.add(signup);
        formPanel.add(back);

        signup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String Fname = tfFirstName.getText();
                String Lname = tfLastName.getText();
                String email = tfEmail.getText();
                String pass = String.valueOf(pfpassword.getPassword());

                Database db = new Database();
                db.SetData(Fname, Lname, email, pass);

            }

        });
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn obj = new SignIn();
                setVisible(false);
                obj.setVisible(true);
                obj.Login();

            }

        });

        setTitle("Registration");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        Signup ob = new Signup();
        ob.Registration();
    }

}
