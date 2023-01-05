import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale.Category;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sendmail extends JFrame {

    String selecttag;

    final private Font mainFont = new Font("", Font.BOLD, 18);

    public void MessageBody(String desieremail) {



        JLabel Recipient = new JLabel("To");
        Recipient.setFont(mainFont);
        JTextField jtrecipient = new JTextField("Recipient");
        jtrecipient.setBounds(0, 0, 500, 20);
        add(Recipient);
        add(jtrecipient);

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
        tSubject.setBounds(0, 20, 500, 20);
        add(Subject);
        add(tSubject);


        String str[] = { "Primary", "Social", "Promotional", "Forum" };
        JComboBox Categories = new JComboBox(str);
        Categories.setBounds(10, 40, 100, 20);
        add(Categories);

        Categories.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selecttag = (String) Categories.getSelectedItem();
            }
        });


        JTextArea textarea = new JTextArea("Message body");
        textarea.setBounds(20, 60, 400, 200);
        add(textarea);




        JButton send = new JButton("Send");
        send.setFont(mainFont);
        send.setBounds(0, 300, 100, 20);

        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                String sendId = desieremail;
                System.out.println(sendId);
                String receivedId = jtrecipient.getText();
                String body = textarea.getText();
                String tag = selecttag;

                Database dbobj = new Database();
                dbobj.sendmail(sendId, receivedId, body, tag);
                setVisible(false);
            }
            
        });

        add(send);

        setTitle("New Massage");
        setBounds(550, 250, 350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }


}
