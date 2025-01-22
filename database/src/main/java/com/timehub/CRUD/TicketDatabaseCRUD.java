package com.timehub.CRUD;

import com.timehub.STATUS;
import com.timehub.exceptions.DatabaseCRUDException;
import com.timehub.exceptions.EntityMappingException;
import com.timehub.pojo.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
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
  public void insert(Ticket ticket) {
    String sql =
        "INSERT INTO tickets (ticket_id, title, description, status, progress, acceptance_criteria, "
            + "history, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, ticket.getId());
      preparedStatement.setString(2, ticket.getTitle());
      preparedStatement.setString(3, ticket.getDescription());
      preparedStatement.setString(4, ticket.getStatus().name());
      preparedStatement.setDouble(5, ticket.getProgress());
      preparedStatement.setString(6, ticket.getAcceptanceCriteria());
      preparedStatement.setString(7, ticket.getHistory());
      preparedStatement.setTimestamp(8, ticket.getCreatedAt());
      preparedStatement.setTimestamp(9, ticket.getUpdatedAt());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new DatabaseCRUDException(
          "Error while inserting into " + this.tableName + " database!", e);
    }
  }

  @Override
  public List<Ticket> select(String sql) {
    List<Ticket> resultList = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        resultList.add(buildEntity(rs));
      }

    } catch (SQLException | EntityMappingException e) {
      throw new RuntimeException(e);
    }

      return resultList;
  }

  @Override
  public List<Ticket> selectAll() {
    List<Ticket> resultList = new ArrayList<>();
    String sql = "SELECT * FROM tickets";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        resultList.add(buildEntity(rs));
      }

    } catch (SQLException | EntityMappingException e) {
      throw new RuntimeException(e);
    }

      return resultList;
  }

  @Override
  public List<Ticket> selectById(int selectById) {
    List<Ticket> resultList = new ArrayList<>();
    String sql = "SELECT * FROM tickets WHERE id = " + selectById;

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        resultList.add(buildEntity(rs));
      }

    } catch (SQLException | EntityMappingException e) {
      throw new RuntimeException(e);
    }

      return resultList;
  }

  @Override
  public void update(Ticket ticket) {
    String sql =
        "UPDATE tickets SET title = ?, description = ?, status = ?, progress = ?, acceptance_criteria = ?, "
            + "history = ?, updated_at WHERE id = "
            + ticket.getId();

    try {

      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, ticket.getTitle());
      preparedStatement.setString(2, ticket.getDescription());
      preparedStatement.setString(3, ticket.getStatus().name());
      preparedStatement.setDouble(4, ticket.getProgress());
      preparedStatement.setString(5, ticket.getAcceptanceCriteria());
      preparedStatement.setString(6, ticket.getHistory());
      preparedStatement.setTimestamp(7, ticket.getUpdatedAt());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new DatabaseCRUDException("Error while updating " + this.tableName + " database!", e);
    }
  }

  @Override
  public void delete(Ticket ticket) {
    String sql = "DELETE FROM tickets WHERE id = " + ticket.getId();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseCRUDException(
          "Error while deleting the id "
              + ticket.getId()
              + " from the "
              + this.tableName
              + " database!",
          e);
    }
  }

  @Override
  public Ticket buildEntity(ResultSet resultSet) throws EntityMappingException {
    try {
      int id = resultSet.getInt("id");
      String title = resultSet.getString("title");
      String description = resultSet.getString("description");
      STATUS status = STATUS.valueOf(resultSet.getString("status"));
      double progress = resultSet.getDouble("progress");
      String acceptanceCriteria = resultSet.getString("acceptance_criteria");
      String history = resultSet.getString("history");
      Timestamp createdAt = resultSet.getTimestamp("created_at");
      Timestamp updatedAt = resultSet.getTimestamp("updated_at");

      return new Ticket(
          id,
          title,
          description,
          status,
          progress,
          acceptanceCriteria,
          history,
          createdAt,
          updatedAt);
    } catch (SQLException e) {
      throw new EntityMappingException(
          "Error while creating the ticket object based on the result set!", e);
    } catch (IllegalArgumentException e) {
      throw new EntityMappingException(
          "Invalid value for the status enum in the ticket object!", e);
    }
  }
}
