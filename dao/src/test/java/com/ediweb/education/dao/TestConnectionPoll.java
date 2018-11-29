package com.ediweb.education.dao;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionPoll {

    private Connection Connection;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        Assert.assertNotNull(connection);
        Assert.assertTrue(connection.isValid(0));
        connection.close();
    }

}
