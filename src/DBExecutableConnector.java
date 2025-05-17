import java.sql.*;

public class DBExecutableConnector extends DBConnector{

    DBExecutableConnector(DBConfig config) {
        super(config);
    }

    public ResultSet executeSelect(String query) throws SQLException {
        Connection curConnection = this.getConnection();
        Statement statement = curConnection.createStatement();

        return statement.executeQuery(query);
    }

}

// класс добавляет в ДБКоннектор методы, которые выполняют запросы
