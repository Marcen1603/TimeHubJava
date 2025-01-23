package com.timehub;

import com.timehub.CRUD.TicketDatabaseCRUD;
import com.timehub.configuration.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();
        TicketDatabaseCRUD ticketDatabaseCRUD = new TicketDatabaseCRUD(connection);
        ticketDatabaseCRUD.createTable();

    }
}