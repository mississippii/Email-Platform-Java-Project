import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

public class NewsFeed extends JFrame {

    private String[] inbox = { "Id" };
    // private String [][] row={
    // {"101","Tanvir","2.90"},
    // {"102", "Saiful", "3.52" },
    // {"103","Rony","3.42"},
    // {"104","Tapajit","3.32"}
    // };

    private ArrayList<String> row = new ArrayList<>();


    public void showitem(ArrayList<String> row) {
        String[][] tmpObj = new String[row.size()][1];

        for (int i = 0; i < row.size(); i++) {
            tmpObj[i][0] = row.get(i);
        }
        JTable intable = new JTable(tmpObj, inbox);
        JScrollPane scroll = new JScrollPane(intable);
    }

    public void Inbox(String email)
    {
        JPanel Opanel = new JPanel();
        Opanel.setBounds(0, 0, 100, 600);
        Opanel.setBackground(Color.CYAN);

        JButton Compose = new JButton("Compose");
        Compose.setBounds(0, 10, 50, 25);
        Compose.setVisible(true);

        Compose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Sendmail objs = new Sendmail();
                objs.MessageBody(email);
                objs.setVisible(true);
                
            }
        
        });

        String str[] = { "Primary", "Social", "Promotional", "Forum" };
        JComboBox Categories = new JComboBox(str);
        Categories.setBounds(0, 62, 50, 25);

        JPanel Tablepanel = new JPanel();
        Tablepanel.setBounds(100, 0, 400, 600);
        Tablepanel.setBackground(Color.LIGHT_GRAY);

        // Database dbobj = new Database();
        // row = dbobj.receivemail(email);
        //showitem(row);
       

        JButton Sent = new JButton("Sent");
        Sent.setBounds(0, 36, 50, 25);

        Sent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Database dbobj = new Database();
                row = dbobj.sentmail(email);
                showitem(row);
            }

        });


        Opanel.add(Compose);
        Opanel.add(Sent);
        Opanel.add(Categories);
        Opanel.setLayout(new FlowLayout());
        add(Opanel);
        
        //Tablepanel.add(scroll);

        add(Tablepanel);

        setTitle("Inbox");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

}
