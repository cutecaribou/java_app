import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello :)");

        File myObj = new File("src/config.json");
        Scanner myReader = new Scanner(myObj);
        StringBuilder strConfig = new StringBuilder();
        while (myReader.hasNextLine()) {
            strConfig.append(myReader.nextLine());
        }
        System.out.println(strConfig);
        myReader.close();

        DBConfig config = new ObjectMapper().readValue(strConfig.toString(), DBConfig.class);
        System.out.println(config);

        DBConnector connector = new DBConnector(config);
        Connection connection = connector.connect();

//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(jdbcUrl, username, password);
//            System.out.println("Connected to Postgres");
//
//            Statement statement = connection.createStatement();
//            String query = "";
//
//            try {
//                File myObj = new File("src/a.txt");
//                Scanner myReader = new Scanner(myObj);
//                while (myReader.hasNextLine()) {
//                    query = myReader.nextLine();
//                    System.out.println("SQL query is: " + query);
//                }
//                myReader.close();
//            } catch (FileNotFoundException e) {
//                System.out.println("Error");
//                e.printStackTrace();
//            }
//
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                String value = resultSet.getString("my_date");
//                System.out.print("my_date = " + value + "; ");
//
//                value = resultSet.getString("number");
//                System.out.println("value = " + value);
//            }
//
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}