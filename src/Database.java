import java.sql.*;

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
            conn.close();

        } catch (Exception e) {
            System.out.println("Invalid email or password");

        }
    }

    public void varification(String email, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/romatoomail", "root", "1234");

            String que = "SELECT EmailId FROM emailuser WHERE EmailId=\""+email+"\" AND Pass=\""+pass+"\"";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(que);
            System.out.println("Hello: "+rs.getString(que));
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}