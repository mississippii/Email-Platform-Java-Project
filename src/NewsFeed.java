import java.awt.*;

import javax.swing.*;

public class NewsFeed extends JFrame {
    
    public void Inbox()
    {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 600));
        setVisible(true);
    }

    public static void main(String[] args) {
        NewsFeed obj = new NewsFeed();
        obj.Inbox();
    }
}
