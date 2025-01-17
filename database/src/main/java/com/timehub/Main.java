package com.timehub;

import com.timehub.configuration.DatabaseConnection;

import java.sql.Connection;

import static com.timehub.configuration.DatabaseCRUD.createTables;
import static com.timehub.configuration.DatabaseCRUD.listTables;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();
        createTables(connection);
        listTables(connection);

    }
}