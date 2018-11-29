package com.ediweb.education.dao;

import com.ediweb.education.entities.Route;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteDAO implements DAO<Route> {

    private static Logger log = Logger.getLogger(RouteDAO.class.getName());

    private static final String SQL_SELECT_ALL_ROUTES = "SELECT id, owner_id, sender, receiver FROM routes";
    private static final String SQL_SELECT_ROUTE_BY_ID = "SELECT id, owner_id, sender, receiver FROM routes WHERE id = ?";
    private static final String SQL_INSERT_ROUTE = "INSERT INTO routes (owner_id, sender, receiver) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE_ROUTE = "UPDATE routes SET owner_id = ?, sender = ?, receiver = ? WHERE id = ?";
    private static final String SQL_DELETE_ROUTE_BY_ID = "DELETE FROM routes WHERE id = ?";
    private static final String SQL_DELETE_ROUTE = "DELETE FROM routes WHERE id = ?";

    private Connection connection;

    RouteDAO() {
    }

    RouteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Route find(int id) {
        return null;
    }

    @Override
    public Route find(Route entity) {
        return null;
    }

    @Override
    public void create(Route entity) {

    }

    @Override
    public void update(Route entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Route entity) {

    }

    @Override
    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        }
    }

    @Override
    public void close(Connection connection) {
        throw new UnsupportedOperationException();
    }

}