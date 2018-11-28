package com.ediweb.education.dao;

import org.postgresql.ds.PGConnectionPoolDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static final String DATASOURCE_NAME = "jdbc/education_edi";
    private static DataSource dataSource;

    static {
        try {
            PGConnectionPoolDataSource pgConnectionPoolDataSource = new PGConnectionPoolDataSource();
            pgConnectionPoolDataSource.setServerName();
            pgConnectionPoolDataSource.setDatabaseName();
            pgConnectionPoolDataSource.setPortNumber();
            pgConnectionPoolDataSource.setUser();
            pgConnectionPoolDataSource.setPassword();
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    // метод возвращения Connection в пул

 /* Соединение извлекается из пула очень просто:
    Connection connection = dataSource.getConnection();
    После выполнения запроса соединение завершается, и его объект должен
    быть возвращен обратно в пул вызовом:
    connection.close();*/

}
