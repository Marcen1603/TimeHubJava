package com.timehub.configuration.CRUD;

import com.timehub.ticketsystem.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

import static com.timehub.configuration.DatabaseSchema.*;

public class TicketDatabaseCRUD extends DatabaseCRUD<Ticket> {

    private static final Logger logger = LoggerFactory.getLogger(TicketDatabaseCRUD.class);

    public TicketDatabaseCRUD(Connection connection) {
        super(connection);
    }


    @Override
    public void createTable() {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(getCreateTicketTableSQL());
        } catch (SQLException e) {
            logger.error("Error while trying to create the database: {}", e.getMessage());
        }
    }

    @Override
    public void insert() {

    }

    @Override
    public void select() {

    }

    @Override
    public List<ResultSet> selectAll() {
        return List.of();
    }

    @Override
    public ResultSet selectById(int id) {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void listTableContent() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", new String[] {"TABLE"});
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                logger.info("Table: {}", tableName);
            }
        } catch (SQLException e) {
            logger.error("Error while trying to get all tables from the database");
        }
    }
}
