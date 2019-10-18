package chapter_12.task_A_2;

import java.sql.*;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConnectorDB {

    private Connection connection;

    public ConnectorDB() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("chapter_12_DB");
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (MissingResourceException e) {
            System.err.println("properties file is missing " + e);
        } catch (SQLException e) {
            System.err.println("not obtained connection " + e);
        }

    }

    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(sql);
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or statement is null");
    }

    public Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or statement is null");
    }



    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("statement is null " + e);
            }
        }
    }
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(" wrong connection" + e);
            }
        }
    }

}
