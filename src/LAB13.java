import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB13 {
    public static void main(String[] args) {

        Connect connect = new Connect();
        String url = connect.getUrl();
        String username = connect.getUsername();
        String password = connect.getPassword();

        try {
            // Connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE mydb2.student SET email = ? WHERE studentID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "example.com@gmail.com");
            statement.setInt(2, 651114);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
