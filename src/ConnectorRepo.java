import java.util.HashMap;

public class ConnectorRepo {
    private HashMap<Integer, DBConnector> connectorMap;
    private int id;

    ConnectorRepo() {
        id = 0;
        connectorMap = new HashMap<>();
    }

    public int createConnector(DBConfig config) {
        DBConnector curConnector = new DBConnector(config);
        ++id;
        connectorMap.put(id, curConnector);
        return id;
    }

    public DBConnector getConnector(int id) {
        return connectorMap.get(id);
    }
}
