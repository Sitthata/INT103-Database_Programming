import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class LAB12 {
    public static void main(String[] args) {

        Connect connect = new Connect();

        String url = connect.getUrl();
        String username = connect.getUsername();
        String password = connect.getPassword();

        try {
            // Connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO mydb2.student(studentID, firstName, lastName, email, deptID) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 651115);
            statement.setString(2, "Jane");
            statement.setString(3, "Doe");
            statement.setString(4, "jane.doe@email.com");
            statement.setString(5, "IT");

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
