public class DBConfig {
    public String host;
    public String port;
    public String login;
    public String password;
    public String driver;
    public String database;

    public String toString() {
        return "DBConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", login='" + login +  '\'' +
                ", password='" + password +  '\'' +
                ", driver='" + driver +  '\'' +
                ", database='" + database +  '\'' +
                '}';
    }

}
