public class Connect {
    private String url;
    private String username;
    private String password;

    public Connect() {
        url = "jdbc:mysql://localhost:3306/mydb2";
        username = "root";
        password = "deeprock25";
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
