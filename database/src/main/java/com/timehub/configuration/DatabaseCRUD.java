package com.timehub.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import static com.timehub.configuration.DatabaseSchema.getCreateTicketTableSQL;
import static com.timehub.configuration.DatabaseSchema.getCreateTimeEntryTableSQL;

public class DatabaseCRUD {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseCRUD.class);

    /**
     * Every relational database need tables to save content. The needed tables are created in this
     * class, for each new table which must be initialized can be added to this class.
     *
     * @param conn the {@link Connection} object of the database to communicate with it.
     */
    public static void createTables(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(getCreateTicketTableSQL());
            stmt.executeUpdate(getCreateTimeEntryTableSQL());

        } catch (SQLException e) {
            logger.error("Error while trying to create the database: {}", e.getMessage());
        }
    }

    /**
     * To get an overview, this method is used to show all existing tables from the database
     *
     * @param conn the {@link Connection} object of the database to communicate with it.
     */
    public static void listTables(Connection conn) {
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                logger.info("Table: {}", tableName);
            }
        } catch (SQLException e) {
            logger.error("Error while trying to get all tables from the database");
        }
    }
}
