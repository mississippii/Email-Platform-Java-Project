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

        /*********** Registration Form **********************/

        SignIn Hobj = new SignIn();
        Hobj.setVisible(false);
        JLabel RgForm = new JLabel("Registration Form", SwingConstants.CENTER);
        RgForm.setFont(mainFont);
        add(RgForm);

        JLabel FirstName = new JLabel("First Name");
        FirstName.setFont(mainFont);
        tfFirstName = new JTextField();

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

        JPanel RgPanel = new JPanel();
        RgPanel.setLayout(new GridLayout(0, 1, 10, 10));
        RgPanel.add(RgForm);
        RgPanel.add(FirstName);
        RgPanel.add(tfFirstName);
        RgPanel.add(LastName);
        RgPanel.add(tfLastName);
        RgPanel.add(Email);
        RgPanel.add(tfEmail);
        RgPanel.add(Password);
        RgPanel.add(pfpassword);
        
        add(RgPanel, BorderLayout.NORTH);

         /******** Create Button ********/
         JButton signup = new JButton("Creat Account");
        

         JButton back = new JButton("Back");


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

        
        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new GridLayout(1, 2, 10, 0));
        btnpanel.add(signup);
        btnpanel.add(back);
        add(btnpanel, BorderLayout.SOUTH);

        setTitle("Registration");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        Signup ob = new Signup();
        ob.Registration();
    }

}
