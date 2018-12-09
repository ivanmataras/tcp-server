package com.ediweb.education.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class TestConnectionPoll {

    private static final Logger log = Logger.getLogger(TestConnectionPoll.class.getName());

    private Connection connection;

    @Test @Before
    public void testOpenConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        Assert.assertTrue(connection.isValid(0));
    }

    @Test @After
    public void testCloseConnection() throws SQLException {
        connection.close();
        Assert.assertFalse(connection.isValid(0));
    }

}
