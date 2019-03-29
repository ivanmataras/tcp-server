package com.ediweb.education.dao;

import com.ediweb.education.entities.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteDAO implements DAO<Route> {

    private static final Logger log = Logger.getLogger(RouteDAO.class.getName());

    private static final String SQL_SELECT_ALL_ROUTES = "SELECT id, owner_id, sender_id, receiver_id FROM routes";
    private static final String SQL_DELETE_ALL_ROUTES = "DELETE FROM routes";
    private static final String SQL_SELECT_ROUTE_BY_ID = "SELECT id, owner_id, sender_id, receiver_id FROM routes WHERE id = ?";
    private static final String SQL_SELECT_ROUTE = "SELECT id, owner_id, sender_id, receiver_id FROM routes WHERE id = ?";
    private static final String SQL_INSERT_ROUTE = "INSERT INTO routes (owner_id, sender_id, receiver_id) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE_ROUTE = "UPDATE routes SET owner_id = ?, sender_id = ?, receiver_id = ? WHERE id = ?";
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
        List<Route> routes = new ArrayList<Route>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_ROUTES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Route route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setOwnerId(resultSet.getInt("owner_id"));
                route.setSenderId(resultSet.getInt("sender_id"));
                route.setReceiverId(resultSet.getInt("receiver_id"));
                routes.add(route);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return routes;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_ROUTES);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public Route find(int id) {
        Route route = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ROUTE_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setOwnerId(resultSet.getInt("owner_id"));
                route.setSenderId(resultSet.getInt("sender_id"));
                route.setReceiverId(resultSet.getInt("receiver_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return route;
    }

    @Override
    public Route find(Route route) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ROUTE);
            statement.setInt(1, route.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                route = new Route();
                route.setId(resultSet.getInt("id"));
                route.setOwnerId(resultSet.getInt("owner_id"));
                route.setSenderId(resultSet.getInt("sender_id"));
                route.setReceiverId(resultSet.getInt("receiver_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return route;
    }

    @Override
    public void create(Route route) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_ROUTE);
            statement.setInt(1, route.getOwnerId());
            statement.setInt(2, route.getSenderId());
            statement.setInt(3, route.getReceiverId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(Route route) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_ROUTE);
            statement.setInt(1, route.getOwnerId());
            statement.setInt(2, route.getSenderId());
            statement.setInt(3, route.getReceiverId());
            statement.setInt(4, route.getId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ROUTE_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Route route) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ROUTE);
            statement.setInt(1, route.getId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
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