import java.sql.*;

public class ConnectorManager {
    private ConnectorRepo repo;

    ConnectorManager() {
        repo = new ConnectorRepo();
    }

    public ResultSet executeSelect(int conId, String query) throws SQLException {
        DBConnector connector = repo.getConnector(conId);
        Connection curConnection = connector.getConnection();

        Statement statement = curConnection.createStatement();
        return statement.executeQuery(query);
    }

    public int createConnector(DBConfig config) {
        return repo.createConnector(config);
    }
}
