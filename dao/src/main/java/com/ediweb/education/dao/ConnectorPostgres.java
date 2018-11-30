package com.ediweb.education.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ConnectorPostgres {

    private static final Logger log = Logger.getLogger(ConnectorPostgres.class.getName());

    public static Connection getConnection() throws SQLException {

        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        return DriverManager.getConnection(url, user, pass);

    }

}
