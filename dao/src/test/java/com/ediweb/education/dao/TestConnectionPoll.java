package com.ediweb.education.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnectionPoll {

    @Test
    public void testGeneralTest() {
        Connection connection;
        connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try {
            final Properties clientInfo = connection.getClientInfo();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Test
    public void testConnectionPoll() {

    }

    @Test
    public void testGetConnection() {


    }

    @Test
    public void testCloseConnection() {

    }

}
