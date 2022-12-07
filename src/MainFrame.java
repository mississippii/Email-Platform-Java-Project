import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
        
    String str= "u1604090@yahoo.com";
    String regex = "^(.+)@(.+)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(str);
    System.out.println(matcher.matches());

    }

    }
