import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewsFeed extends JFrame {

    private String[] inbox = { "Inbox" };
    String selecttag;
    // private String[][] rows = {
    // { "101", "Tanvir", "2.90" },
    // { "102", "Saiful", "3.52" },
    // { "103", "Rony", "3.42" },
    // { "104", "Tapajit", "3.32" }
    // };

    private ArrayList<String> row = new ArrayList<>();


    // public void showitem(ArrayList<String> row) {

    // }

    public void Inbox(String email)
    {
        setTitle("Inbox");
        setSize(500, 600);
        // setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setResizable(false);
        // setLayout(null);
        setVisible(true);

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
        JButton Inbox = new JButton("Inbox");

        String[][] tmpObj = new String[100][1];
        Inbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Database rmobj = new Database();
                row = rmobj.receivemail(email);
                for (int i = 0; i < row.size(); i++) {
                    System.out.println("Newsfeed" + row.size());
                    tmpObj[i][0] = row.get(i);
                }

                DefaultTableModel model = new DefaultTableModel(tmpObj, inbox);
                JTable intable = new JTable(model);
                JPanel Tablepanel = new JPanel();

                Tablepanel.setBounds(100, 0, 400, 600);
                Tablepanel.setBackground(Color.LIGHT_GRAY);
                add(intable);
                add(new JScrollPane(intable));
                validate();

                add(Tablepanel);

            }

        });

        JButton Sent = new JButton("Sent");
        Sent.setBounds(0, 36, 50, 25);

        String str[] = { "Categories", "Primary", "Social", "Promotional", "Forum" };
        JComboBox Categories = new JComboBox(str);
        Categories.setBounds(0, 62, 50, 25);

        Categories.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selecttag = (String) Categories.getSelectedItem();
                Database tagobj = new Database();

                // Database dbobj = new Database();
                row = tagobj.categories(selecttag, email);
                for (int i = 0; i < row.size(); i++) {
                    System.out.println("Newsfeed : " + row.size());
                    tmpObj[i][0] = row.get(i);
                }

                DefaultTableModel model = new DefaultTableModel(tmpObj, inbox);
                JTable intable = new JTable(model);
                JPanel Tablepanel = new JPanel();

                Tablepanel.setBounds(100, 0, 400, 600);
                Tablepanel.setBackground(Color.LIGHT_GRAY);
                add(intable);
                add(new JScrollPane(intable));
                validate();

                add(Tablepanel);
            }
        });

        // Database dbobj = new Database();
        // row = dbobj.receivemail(email);
        // showitem(row);

        Sent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Database dbobj = new Database();
                row = dbobj.sentmail(email);
                for (int i = 0; i < row.size(); i++) {
                    System.out.println("Newsfeed" + row.size());
                    tmpObj[i][0] = row.get(i);
                }

                DefaultTableModel model = new DefaultTableModel(tmpObj, inbox);
                JTable intable = new JTable(model);
                JPanel Tablepanel = new JPanel();

                Tablepanel.setBounds(100, 0, 400, 600);
                Tablepanel.setBackground(Color.LIGHT_GRAY);
                add(intable);
                add(new JScrollPane(intable));
                validate();

                add(Tablepanel);
            }

        });
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignIn obj = new SignIn();
                obj.setVisible(true);
                obj.Login();
            }

        });


        Opanel.add(Compose);
        Opanel.add(Inbox);
        Opanel.add(Sent);
        Opanel.add(Categories);
        Opanel.add(back);
        Opanel.setLayout(new FlowLayout());
        add(Opanel);

        // model.setColumnIdentifiers(inbox);

        // JPanel Tablepanel = new JPanel();

        // Tablepanel.setBounds(100, 0, 400, 600);
        // Tablepanel.setBackground(Color.LIGHT_GRAY);
        // add(intable);
        // add(new JScrollPane(intable));
        // validate();

        // add(Tablepanel);

    }

     // public static void main(String[] args) {
     // NewsFeed ob = new NewsFeed();
     // ob.Inbox("u1604090@student.cuet.ac.bd");
     // }

}
