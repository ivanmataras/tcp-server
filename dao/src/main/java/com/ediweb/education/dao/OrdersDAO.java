package com.ediweb.education.dao;


import com.ediweb.education.entities.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersDAO implements DAO<Orders> {

    private static final Logger log = Logger.getLogger(OrdersDAO.class.getName());

    private static final String SQL_SELECT_ALL_DOCUMENTS = "SELECT id, number, date, type_id, status_id, filename, sender_id, receiver_id FROM documents WHERE type_id = ?";
    private static final String SQL_DELETE_ALL_DOCUMENTS = "DELETE FROM documents WHERE type_id = ?";
    private static final String SQL_SELECT_DOCUMENT_BY_ID = "SELECT id, number, date, type_id, status_id, filename, sender_id, receiver_id FROM documents WHERE type_id = ? AND id = ?";
    private static final String SQL_SELECT_DOCUMENT = "SELECT id, number, date, type_id, status_id, filename, sender_id, receiver_id FROM documents WHERE type_id = ? AND id = ?";
    private static final String SQL_INSERT_DOCUMENT = "INSERT INTO documents (number, date, type_id, status_id, filename, sender_id, receiver_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DOCUMENT = "UPDATE documents SET number = ?, date = ?, type_id = ?, status_id = ?, filename = ?, sender_id = ?, receiver_id = ? WHERE type_id = ? AND id = ?";
    private static final String SQL_DELETE_DOCUMENT_BY_ID = "DELETE FROM documents WHERE type_id = ? AND id = ?";
    private static final String SQL_DELETE_DOCUMENT = "DELETE FROM documents WHERE type_id = ? AND id = ?";

    private Connection connection;

    public OrdersDAO() {

    }

    public OrdersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> orderss = new ArrayList<Orders>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_DOCUMENTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Orders orders = new Orders();
                orders.setId(resultSet.getInt("id"));
                orders.setNumber(resultSet.getInt("number"));
                orders.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
                orders.setTypeId(resultSet.getInt("type_id"));
                orders.setStatusId(resultSet.getInt("status_id"));
                orders.setFileName(resultSet.getString("filename"));
                orders.setSenderId(resultSet.getInt("sender_id"));
                orders.setReceiverId(resultSet.getInt("receiver_id"));
                orderss.add(orders);
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return orderss;
    }

    @Override
    public void deleteAll() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ALL_DOCUMENTS);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public Orders find(int id) {
        Orders orders = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_DOCUMENT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders = new Orders();
                orders.setId(resultSet.getInt("id"));
                orders.setNumber(resultSet.getInt("number"));
                orders.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
                orders.setTypeId(resultSet.getInt("type_id"));
                orders.setStatusId(resultSet.getInt("status_id"));
                orders.setFileName(resultSet.getString("filename"));
                orders.setSenderId(resultSet.getInt("sender_id"));
                orders.setReceiverId(resultSet.getInt("receiver_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return orders;
    }

    @Override
    public Orders find(Orders orders) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_DOCUMENT);
            statement.setInt(1, orders.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders = new Orders();
                orders.setId(resultSet.getInt("id"));
                orders.setNumber(resultSet.getInt("number"));
                orders.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
                orders.setTypeId(resultSet.getInt("type_id"));
                orders.setStatusId(resultSet.getInt("status_id"));
                orders.setFileName(resultSet.getString("filename"));
                orders.setSenderId(resultSet.getInt("sender_id"));
                orders.setReceiverId(resultSet.getInt("receiver_id"));
            }
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
        return orders;
    }

    @Override
    public void create(Orders orders) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_DOCUMENT);
            statement.setInt(1, orders.getNumber());
            statement.setTimestamp(2, Timestamp.valueOf(orders.getDate().atStartOfDay()));
            statement.setInt(3, DocumentTypeId.ORDERS.getDocumentTypeId());
            statement.setInt(4, orders.getStatusId());
            statement.setString(5, orders.getFileName());
            statement.setInt(6, orders.getSenderId());
            statement.setInt(7, orders.getReceiverId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void update(Orders orders) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_DOCUMENT);
            statement.setInt(1, orders.getNumber());
            statement.setTimestamp(2, Timestamp.valueOf(orders.getDate().atStartOfDay()));
            statement.setInt(3, DocumentTypeId.ORDERS.getDocumentTypeId());
            statement.setInt(4, orders.getStatusId());
            statement.setString(5, orders.getFileName());
            statement.setInt(6, orders.getSenderId());
            statement.setInt(7, orders.getReceiverId());
            statement.setInt(8, orders.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_DOCUMENT_BY_ID);
            statement.setInt(1, DocumentTypeId.ORDERS.getDocumentTypeId());
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            if (log.isLoggable(Level.SEVERE)) log.severe(sqlException.getMessage());
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Orders orders) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_DOCUMENT);
            statement.setInt(1, DocumentTypeId.ORDERS.getDocumentTypeId());
            statement.setInt(2, orders.getId());
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
