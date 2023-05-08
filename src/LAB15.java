import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB15 {
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mydb2.student");
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            for(int i = 1; i <= rsMetaData.getColumnCount(); i++)
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
            System.out.println();

            while(resultSet.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
                    System.out.printf("%-12s\t", resultSet.getObject(i));
                System.out.println();
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LAB07.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
