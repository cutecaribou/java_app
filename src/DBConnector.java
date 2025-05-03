import java.sql.*;

public class DBConnector {
    private final DBConfig config;
    private Connection connection;

    DBConnector(DBConfig config) {
        this.config = config;
        this.connection = null;
    }

    private void connect() throws SQLException {
        if (this.connection != null) {
            closeConnection();
        }
        String jdbcUrl = "jdbc:" + config.driver + "://" + config.host + ":" + config.port + "/" + config.database;
        this.connection = DriverManager.getConnection(jdbcUrl, config.login, config.password);

        System.out.println("Connected");
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null)
                connect();

        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            this.connection.close();
        }
        connection = null;
        System.out.println("Connection is closed");
    }
}
