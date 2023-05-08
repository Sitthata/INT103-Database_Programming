import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class LAB08 {
    public static void main(String[] args) {

        Connect connect = new Connect();

        String url = connect.getUrl();
        String username = connect.getUsername();
        String password = connect.getPassword();

        try {
            // Connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student";
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                for(int i = 1; i <= 4; i++) {
                    System.out.print(resultSet.getString(i));
                    System.out.println();
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

