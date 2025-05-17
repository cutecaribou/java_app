import java.sql.*;

public class ConnectorManager {
    private ConnectorRepo repo;

    ConnectorManager() {
        repo = new ConnectorRepo();
    }

    public ResultSet executeSelect(int conId, String query) throws SQLException {
        DBExecutableConnector connector = repo.getConnector(conId);

        return connector.executeSelect(query);
    }

    public int createConnector(DBConfig config) {
        return repo.createConnector(config);
    }
}
