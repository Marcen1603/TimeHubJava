package com.timehub.configuration;

import com.timehub.exceptions.DatabaseConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.timehub.configuration.DatabaseConfig.*;

/**
 * To send requests and get responds a connection to the database is necessary. The handling of all
 * connection aspects are handled in this class.
 */
public class DatabaseConnection {

  private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);

  /**
   * @return a {@link Connection} object which holds the connection to the database, otherwise it is
   *     null
   */
  public static Connection getConnection() {

    createDatabaseStoragePath();

    for (int i = 1; i <= NUMBER_OF_CONNECTION_RETRIES; i++) {
      try {
        Connection conn = DriverManager.getConnection(getDatabaseUrl());
        logger.info("Connection to SQLite has been established.");
        return conn;
      } catch (SQLException e) {
        logger.error(
            "Failed to connect to SQLite database (Attempt {} of "
                + NUMBER_OF_CONNECTION_RETRIES
                + ").",
            i);
        try {
          Thread.sleep(DURATION_TO_WAIT_BETWEEN_RETRIES);
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt();
          throw new DatabaseConnectionException("Retry was interrupted.", ie);
        }
      }
    }
    throw new DatabaseConnectionException(
        "Failed to connect to SQLite database after " + NUMBER_OF_CONNECTION_RETRIES + " attempts.",
        new RuntimeException());
  }

  /**
   * To store the database file, the path must exist. In this method the path to the location will
   * be created.
   */
  private static void createDatabaseStoragePath() {
    File parentDir = new File(DB_PATH).getParentFile();
    if (!parentDir.exists() && !parentDir.mkdirs()) {
      throw new RuntimeException("Failed to create directory: " + parentDir.getAbsolutePath());
    }
  }
}
