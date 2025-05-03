import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello :)");

        File configFile = new File("src/config.json");
        Scanner myReader = new Scanner(configFile);

        StringBuilder strConfig = new StringBuilder();
        while (myReader.hasNextLine()) {
            strConfig.append(myReader.nextLine());
        }
        System.out.println(strConfig);
        myReader.close();

        DBConfig config = new ObjectMapper().readValue(strConfig.toString(), DBConfig.class);
        System.out.println(config);

        ConnectorManager manager = new ConnectorManager();
        int id = manager.createConnector(config);

        ResultSet resultSet = manager.executeSelect(id, "Select * from a");
        while (resultSet.next()) {
            String value = resultSet.getString("my_date");
            System.out.print("my_date = " + value + "; ");

            value = resultSet.getString("number");
            System.out.println("value = " + value);
        }

    }
}