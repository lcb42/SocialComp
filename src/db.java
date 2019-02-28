import java.sql.*;

public class db {
    //sqlite database to handle the ratings data

    private final String url = "jdbc:postgresql://localhost/ratings";
    private final String user = "postgres";
    private final String password = "superman";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
