import java.awt.Color;

import javax.swing.*;

public class NewsFeed extends JFrame {
    
    public void Inbox()
    {
        JPanel Opanel = new JPanel();
        Opanel.setBounds(10, 10, 150, 600);
        Opanel.setBackground(Color.CYAN);

        JButton Compose = new JButton("Compose");
        Compose.setBounds(10, 10, 150, 25);
        Compose.setVisible(true);

        JButton Sent = new JButton("Sent");
        Sent.setBounds(10, 36, 150, 25);

        String str[] = { "Primary", "Social", "Promotional", "Forum" };
        JComboBox Categories = new JComboBox(str);
        Categories.setBounds(10, 62, 150, 25);
        
        Opanel.add(Compose);
        Opanel.add(Sent);
        Opanel.add(Categories);
        add(Opanel);

        setTitle("Inbox");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        NewsFeed obj = new NewsFeed();
        obj.Inbox();
    }
}
