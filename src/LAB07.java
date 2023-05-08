import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB07 {
    public static void main(String[] args) {
        Connect connect = new Connect();
        String url = connect.getUrl();
        String username = connect.getUsername();
        String password = connect.getPassword();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            Statement statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
