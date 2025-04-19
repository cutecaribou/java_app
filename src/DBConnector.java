import java.sql.*;

public class DBConnector {
    private final DBConfig config;

    DBConnector(DBConfig config) {
        this.config = config;
    }

    public Connection connect() throws SQLException {
        String jdbcUrl = "jdbc:" + config.driver + "://" + config.host + ":" + config.port + "/" + config.database;
        Connection connection = DriverManager.getConnection(jdbcUrl, config.login, config.password);
        return connection;
    }
}
