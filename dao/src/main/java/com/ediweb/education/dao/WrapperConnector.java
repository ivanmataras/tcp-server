package com.ediweb.education.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WrapperConnector {

    private static Logger log = Logger.getLogger(WrapperConnector.class.getName());

    private Connection connection;

    public WrapperConnector() {
        try {
            String url = ConnectionConfigurationManager.getProperty("url");
            Properties properties = new Properties();
            properties.put("user", ConnectionConfigurationManager.getProperty("user"));
            properties.put("password", ConnectionConfigurationManager.getProperty("password"));
            connection = DriverManager.getConnection(url, properties);
        } catch (MissingResourceException missingResourceException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(missingResourceException.getMessage());
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }
    }

    public Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("Connection or statement is null");
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException sqlException) {
                if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
            }
        }
    }

    public void closeConnection() {
        if (connection != null) try {
            connection.close();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }
    }

}
