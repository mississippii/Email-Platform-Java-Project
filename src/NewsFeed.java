import java.awt.*;

import javax.swing.*;

public class NewsFeed extends JFrame {
    
    public void Inbox()
    {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,600));
    }

    public static void main(String[] args) {
        NewsFeed obj = new NewsFeed();
        obj.Inbox();
    }
}
