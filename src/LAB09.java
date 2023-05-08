import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB09 {
    public static void main(String[] args) {

        Connect connect = new Connect();

        String url = connect.getUrl();
        String username = connect.getUsername();
        String password = connect.getPassword();

        try {
            // Connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            // Create a statement
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO mydb2.student(studentID, firstName, lastName, email, deptID) " +
                    "VALUES (651114, 'John', 'Doe', 'john.doe@gmail.com', 'IT')";

            statement.executeUpdate(sql);


        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
