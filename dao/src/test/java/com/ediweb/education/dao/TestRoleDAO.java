package com.ediweb.education.dao;

import com.ediweb.education.entities.Role;
import com.ediweb.education.entities.User;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRoleDAO {

    private static final Logger log = Logger.getLogger(TestRoleDAO.class.getName());

    private Connection connection;

    @Test @Ignore
    public void testOpenConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        //Assert.assertNotNull(connection);
        //Assert.assertTrue(connection.isValid(0));
    }

    @Test
    public void testCreateRole() {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }
        Role role = new Role();
        //role.setId();
        role.setName("User");
        role.setFullName("Client user");
        DAO<Role> roleDAO = new RoleDAO(connection);
        roleDAO.create(role);
    }

    @Test
    public void testFindRole() {

    }

    @Test
    public void testUpdateRole() {

    }

    @Test
    public void testDeleteRole() {

    }

    @Test @After @Ignore
    public void testCloseConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        connection.close();
        Assert.assertFalse(connection.isValid(0));
        Assert.assertNull(connection);
    }

}
