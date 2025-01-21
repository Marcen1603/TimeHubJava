package com.timehub;

/**
 * Use these enums as placeholder for the table names in the database of SQLite
 */
public enum TABLE_NAME {
    TICKETS("tickets"),
    TIME_ENTRIES("time_entries"),
    TODOS("to_dos"),
    CONFIGURATION("configuration");

    private final String description;

    TABLE_NAME(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
