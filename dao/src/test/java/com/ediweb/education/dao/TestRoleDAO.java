package com.ediweb.education.dao;

import com.ediweb.education.entities.Role;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class TestRoleDAO {

    private static final Logger log = Logger.getLogger(TestRoleDAO.class.getName());

    private static Connection connection;
    private static DAO<Role> roleDAO;

    @Test
    @BeforeAll
    static void testOpenConnection() throws SQLException {
        connection = ConnectionPool.getConnection();
        assertTrue(connection.isValid(0));
    }

    @Test
    @BeforeAll
    static void testCreateRoleDAO() {
        roleDAO = new RoleDAO(connection);
        assertNotNull(roleDAO);
    }

    @Test
    void testCreateRole() {
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
    @Disabled
    void testFindRole() {

    }

    @Test
    @Disabled
    void testUpdateRole() {

    }

    @Test
    @Disabled
    void testDeleteRole() {
        roleDAO.delete(1);
        roleDAO.delete(2);
    }

    @Test
    @AfterAll
    static void testCloseConnection() throws SQLException {
        connection.close();
        assertFalse(connection.isValid(0));
    }

}
