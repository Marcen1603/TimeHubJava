package com.timehub.configuration;

/**
 * Different configuration parameters are necessary for the underlying database. The part of this
 * configuration is handled in this class.
 */
public class DatabaseConfig {
  public static final String DB_URL = "jdbc:sqlite:localdata/app.db";
  public static final int NUMBER_OF_CONNECTION_RETRIES = 4;
  public static final int DURATION_TO_WAIT_BETWEEN_RETRIES = 10;
}
