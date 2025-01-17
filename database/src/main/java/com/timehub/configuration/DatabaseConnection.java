package com.timehub.configuration;

import com.timehub.exceptions.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.timehub.configuration.DatabaseConfig.*;

/**
 * To send requests and get responds a connection to the database is necessary. The handling of all
 * connection aspects are handled in this class.
 */
public class DatabaseConnection {

  /**
   * @return a {@link Connection} object which holds the connection to the database, otherwise it is
   *     null
   */
  public static Connection getConnection() {
    int attempt = 0;
    while (attempt < NUMBER_OF_CONNECTION_RETRIES) {
      attempt++;
      try {
        Connection conn = DriverManager.getConnection(DB_URL);
        System.out.println("Connection to SQLite has been established.");
        return conn;
      } catch (SQLException e) {
        System.err.println(
            "Failed to connect to SQLite database (Attempt "
                + attempt
                + " of "
                + NUMBER_OF_CONNECTION_RETRIES
                + ").");
        if (attempt >= NUMBER_OF_CONNECTION_RETRIES) {
          throw new DatabaseConnectionException(
              "Failed to connect to SQLite database after "
                  + NUMBER_OF_CONNECTION_RETRIES
                  + " attempts.",
              e);
        }
        try {
          Thread.sleep(DURATION_TO_WAIT_BETWEEN_RETRIES);
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt();
          throw new DatabaseConnectionException("Retry was interrupted.", ie);
        }
      }
    }
    return null;
  }
}
