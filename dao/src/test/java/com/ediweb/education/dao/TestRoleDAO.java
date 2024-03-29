package com.ediweb.education.dao;

import com.ediweb.education.entities.Role;
import com.ediweb.education.entities.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRoleDAO {

    private static final Logger log = Logger.getLogger(TestRoleDAO.class.getName());

    private Connection connection;
    private DAO<Role> roleDAO;

    @Test
    @BeforeEach
    public void testOpenConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        Assertions.assertTrue(connection.isValid(0));
    }

    @Test
    @BeforeEach
    public void testCreateRoleDAO() throws SQLException {
        roleDAO = new RoleDAO(connection);
        Assertions.assertNotNull(roleDAO);
    }

    @Test
    public void testCreateRole() {
/*        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }*/

        roleDAO = new RoleDAO(connection);

        Role role1 = new Role();
        //role1.setId();
        role1.setName("Admin");
        role1.setFullName("Admin user");
        roleDAO.create(role1);

        Role role2 = new Role();
        //role.setId();
        role2.setName("User");
        role2.setFullName("Client user");
        roleDAO.create(role2);

    }

    @Test
    @Ignore
    public void testFindRole() {

    }

    @Test
    @Ignore
    public void testUpdateRole() {

    }

    @Test
    @Ignore
    public void testDeleteRole() {
        roleDAO.delete(1);
        roleDAO.delete(2);
    }

    @Test
    @AfterEach
    public void testCloseConnection() throws SQLException {
        connection.close();
        Assertions.assertFalse(connection.isValid(0));
    }

}
