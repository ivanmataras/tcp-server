package com.ediweb.education.dao;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {

    private static final Logger log = Logger.getLogger(ConnectionPool.class.getName());

    private static final String DATASOURCE_NAME = "jdbc/education_edi";
    private static PGConnectionPoolDataSource dataSource;

    static {
        dataSource = new PGConnectionPoolDataSource();
        dataSource.setServerName(DataSourceConfigurationManager.getProperty("serverName"));
        dataSource.setPortNumber(Integer.valueOf(DataSourceConfigurationManager.getProperty("portNumber")));
        dataSource.setDatabaseName(DataSourceConfigurationManager.getProperty("databaseName"));
        dataSource.setUser(DataSourceConfigurationManager.getProperty("user"));
        dataSource.setPassword(DataSourceConfigurationManager.getProperty("password"));
    }

    private ConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }
    }

}
