package com.timehub.configuration.CRUD;

import com.timehub.TABLE_NAME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;


public abstract class DatabaseCRUD<T> {

  private static final Logger logger = LoggerFactory.getLogger(DatabaseCRUD.class);

  public Connection connection;
  public TABLE_NAME tableName;

    public DatabaseCRUD(Connection connection) {
      this.connection = connection;
  }

  public abstract void createTable();

  public abstract void insert();

  public abstract void select();

  public abstract List<ResultSet> selectAll();

  public abstract ResultSet selectById(int id);

  public abstract void update(T entity);

  public abstract void delete(int id);

  public abstract void listTableContent();


    /**
     * To get an overview, this method is used to show all existing tables from the database
     *
     * @param connection the {@link Connection} object of the database to communicate with it.
     */
    public static void listTableContent(Connection connection) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();

            // Suche gezielt nach der Tabelle mit dem Namen "abc"
            ResultSet resultSet = metaData.getTables(null, null, "abc", new String[] {"TABLE"});

            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");

                // Prüfe, ob der Tabellenname exakt "abc" entspricht
                if ("abc".equalsIgnoreCase(tableName)) {
                    logger.info("Found table: {}", tableName);
                }
            }
        } catch (SQLException e) {
            logger.error("Error while trying to get table 'abc' from the database", e);
        }
    }
}
