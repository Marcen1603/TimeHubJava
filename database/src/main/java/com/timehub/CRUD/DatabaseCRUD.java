package com.timehub.CRUD;

import com.timehub.TABLE_NAME;
import com.timehub.exceptions.EntityMappingException;
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

  public abstract void insert(T entity);

  public abstract List<T> select(String sql);

  public abstract List<T> selectAll();

  public abstract List<T> selectById(int id);

  public abstract void update(T entity);

  public abstract void delete(T entity);

  public abstract T buildEntity(ResultSet resultSet) throws EntityMappingException;

}
