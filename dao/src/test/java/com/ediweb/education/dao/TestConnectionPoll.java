package com.ediweb.education.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestConnectionPoll {

    private static final Logger log = Logger.getLogger(TestConnectionPoll.class.getName());

    private static Connection connection;

    @Test
    @BeforeAll
    static void testOpenConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        assertTrue(connection.isValid(0));
    }

    @Test
    @AfterAll
    static void testCloseConnection() throws SQLException {
        connection.close();
        assertFalse(connection.isValid(0));
    }

}
