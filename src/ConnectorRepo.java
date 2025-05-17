import java.util.HashMap;

public class ConnectorRepo {
    private HashMap<Integer, DBExecutableConnector> connectorMap;
    private int id;

    ConnectorRepo() {
        id = 0;
        connectorMap = new HashMap<>();
    }

    public int createConnector(DBConfig config) {
        DBExecutableConnector curConnector = new DBExecutableConnector(config);
        ++id;
        connectorMap.put(id, curConnector);
        return id;
    }

    public DBExecutableConnector getConnector(int id) {
        return connectorMap.get(id);
    }
}
