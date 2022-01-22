package com.ediweb.education.dao;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class TestConnectionPoll {

    private static final Logger log = Logger.getLogger(TestConnectionPoll.class.getName());

    private Connection connection;

    @Test
    @BeforeEach
    public void testOpenConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        Assertions.assertTrue(connection.isValid(0));
    }

    @Test
    @AfterEach
    public void testCloseConnection() throws SQLException {
        connection.close();
        Assertions.assertFalse(connection.isValid(0));
    }

}
