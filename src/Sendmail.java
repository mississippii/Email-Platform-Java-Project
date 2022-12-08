import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sendmail extends JFrame {

    final private Font mainFont = new Font("", Font.BOLD, 18);

    public void MessageBody() {

        JLabel Recipient = new JLabel("To");
        Recipient.setFont(mainFont);
        JTextField jtrecipient = new JTextField("Recipient");
        jtrecipient.setBounds(50, 100, 200, 30);

        jtrecipient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = "^(.+)@(.+)$";
                String str = jtrecipient.getText();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches() == false) {
                    JOptionPane.showMessageDialog(null, "Invalid Email",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JLabel Subject = new JLabel("Subject");
        JTextField tSubject = new JTextField("Subject");
        tSubject.setBounds(50, 100, 200, 30);

        JFrame textarea = new JFrame();
        textarea.setBounds(0, 100, 200, 30);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.add(Recipient);
        formPanel.add(jtrecipient);
        formPanel.add(Subject);
        formPanel.add(tSubject);
        formPanel.add(textarea);
        add(formPanel, BorderLayout.NORTH);

        setTitle("New Massage");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        // String str= "u1604090@yahoo.com";
        // String regex = "^(.+)@(.+)$";
        // Pattern pattern = Pattern.compile(regex);
        // Matcher matcher = pattern.matcher(str);
        // System.out.println(matcher.matches());
        Sendmail ob = new Sendmail();
        ob.MessageBody();

    }

}
