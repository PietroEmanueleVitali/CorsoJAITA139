package utils;

import errorhandler.IErrorHandling;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Database implements IDatabase {

    // i parametri che ci servono per la connessione al DB
    private static String user = "root";
    private static String password = "root";
    private String path = "jdbc:mysql://localhost:3306/dispenser?useSSL=false&serverTimezone=UTC";

    private Connection connection;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static IDatabase database = null;

    private Database() {
    }

    public static synchronized IDatabase getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public void openConnection() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(path, user, password);

        } catch (SQLException | ClassNotFoundException e) {
            IErrorHandling.errorMessage();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            IErrorHandling.errorMessage();
        }
    }

    // Dovrà resituire 0, 1 o l'id autogenerato  a seconda del risultato
    @Override
    public int executeDML(String query, String table_Id, String... params) {

        openConnection();
        int result = 0;

        String[] columns = { table_Id };

        try {
        PreparedStatement preparedStatement = connection.prepareStatement(query, columns);
        
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setString(i + 1, params[i]);
            }

            result = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                return result;
            }
            preparedStatement.close();
            resultSet.close();
            
        } catch (SQLException e) {
            IErrorHandling.errorMessage();
        }
        
        closeConnection();
        return result;

    }

    @Override
    public Map<Integer, Map<String, String>> executeDQL(String query, String... params) {
        openConnection();
        Map<Integer, Map<String, String>> result = new LinkedHashMap<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < params.length; i++)
            {
                preparedStatement.setString(i + 1, params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Map<String, String> row = new LinkedHashMap<>();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
                {
                    row.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(i));
                }
                result.put(resultSet.getInt(1), row);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            IErrorHandling.errorMessage();
            System.out.println(e.getMessage());
        }

        return result;
        
    }

}
