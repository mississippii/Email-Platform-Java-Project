import java.sql.*;
import java.util.*;

import javax.swing.*;

public class Database {

    public String EmailId;
    public List<String> list = new ArrayList<String>();
    



    public void SetData(String Fname, String Lname, String email, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* create connection */
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/romatoomail", "root", "1234");

            String que = "INSERT INTO emailuser(FirstName,LastName,EmailId,Pass) VALUES(?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(que);

            stmt.setString(1, Fname);
            stmt.setString(2, Lname);
            stmt.setString(3, email);
            stmt.setString(4, pass);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " Account created Successfully");
            Signup obj = new Signup();
            obj.setVisible(false);
            SignIn Sobj = new SignIn();
            Sobj.setVisible(true);
            Sobj.Login();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Email id already has taken");

        }
    }


    public String getemail() {
        System.out.println(EmailId);
        return this.EmailId;
    }


    public void varification(String email, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/romatoomail", "root", "1234");

            String que = "SELECT EmailId FROM emailuser WHERE EmailId=? AND Pass=?";

            PreparedStatement stmt = conn.prepareStatement(que);

            stmt.setString(1, email);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();
            boolean record = false;
            while (rs.next()) {
                record = true;
            }
            if (record == true) {

                NewsFeed nfobj = new NewsFeed();
                nfobj.setVisible(true);
                nfobj.Inbox(email);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email or Password", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    
    public void sendmail(String sendId,String receivedId,String body,String tag)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* create connection */
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/romatoomail", "root", "1234");

            String que = "INSERT INTO information(SendId,ReceivedId,MailBody,Tag) VALUES(?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(que);

            stmt.setString(1, sendId);
            stmt.setString(2, receivedId);
            stmt.setString(3, body);
            stmt.setString(4, tag);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Email was sent");
            Sendmail obj = new Sendmail();
            obj.setVisible(false);
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sendig failed");

        }

    }
    

    public ArrayList<String> receivemail(String useremail)
    {
        ArrayList<String> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/romatoomail", "root", "1234");
            String que = "SELECT* FROM information WHERE ReceivedId=?";
            PreparedStatement stmt = conn.prepareStatement(que);

            stmt.setString(1, useremail);
            ResultSet result = stmt.executeQuery();

            while (result.next() == true) {
                res.add(result.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        NewsFeed sobj = new NewsFeed();
        sobj.showitem(res);
        return res;
    }

    public ArrayList<String> sentmail(String useremail) {
        ArrayList<String> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/romatoomail", "root", "1234");
            String que = "SELECT* FROM information WHERE SendId=?";
            PreparedStatement stmt = conn.prepareStatement(que);
            stmt.setString(1, useremail);
            ResultSet result = stmt.executeQuery();
            while (result.next() == true) {
                 System.out.println(result.getString(2));
                res.add(result.getString(2));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return res;

    }

}