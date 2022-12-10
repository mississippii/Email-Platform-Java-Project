import java.awt.Color;

import javax.swing.*;


public class Demo extends JFrame {
    public void Frame()
    {
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 50, 100);
        panel.setBackground(Color.BLUE);

        JButton button = new JButton("Login");
        setBounds(10, 20, 100, 100);
        panel.add(button);
        add(panel);

        setTitle("Email");
        setBounds(500, 500, 400, 600);
        setVisible(true);
        setLocation(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Demo ob = new Demo();
        ob.Frame();
    }
}
