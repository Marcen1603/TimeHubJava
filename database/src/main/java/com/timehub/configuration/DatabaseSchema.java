package com.timehub.configuration;

/**
 * To separate the sql schemas to create the tables from th CRUD operation class, this file contains
 * just the statements to created the necessary tables.
 */
public class DatabaseSchema {

  /**
   * Getter method which is used for the template of the Ticket database.
   *
   * @return a string which contains the sql statement for the Ticket system
   */
  public static String getCreateTicketTableSQL() {
    return """
                    CREATE TABLE IF NOT EXISTS tickets (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          title TEXT NOT NULL,
                          description TEXT,
                          status TEXT NOT NULL,
                          progress INTEGER,
                          acceptance_criteria TEXT,
                          history TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    );
                """;
  }

  /**
   * Getter method which is used for the template of the TimeEntry database.
   *
   * @return a string which contains the sql statement for the TimeEntry system
   */
  public static String getCreateTimeEntryTableSQL() {
    return """
                    CREATE TABLE IF NOT EXISTS time_entries (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        ticket_id INTEGER NOT NULL,
                        minutes INTEGER NOT NULL,
                        commit_message TEXT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        worked_at TIMESTAMP NOT NULL,
                        FOREIGN KEY (ticket_id) REFERENCES tickets(id)
                    );
                """;
  }

  /**
   * Getter method which is used for the template of the To-Do database.
   *
   * @return a string which contains the sql statement for the TimeEntry system
   */
  public static String getCreateToDoTableSQL() {
    return """
                    CREATE TABLE IF NOT EXISTS to_dos (
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      title TEXT,
                      description TEXT,
                      status TEXT NOT NULL
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                      finished_at TIMESTAMP NOT NULL,
                      );
                    """;
  }

  /**
   * Getter method which is used for the template of the Configuration database.
   *
   * @return a string which contains the sql statement for the TimeEntry system
   */
  public static String getCreateConfigurationTableSQL() {
    return """
                    CREATE TABLE IF NOT EXISTS configuration (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          name TEXT,
                          description TEXT,
                          value TEXT,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                      );
                    """;
  }
}
