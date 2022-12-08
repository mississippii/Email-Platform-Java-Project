import java.sql.*;

import javax.swing.*;

public class Database {

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
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Account already exist");

        }
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
            } 
            else {
                JOptionPane.showMessageDialog(null, "Invalid Email or Password", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}