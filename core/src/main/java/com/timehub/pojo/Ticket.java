package com.timehub.pojo;

import com.timehub.STATUS;

import java.sql.Timestamp;

public class Ticket {

  private int id;
  private String title;
  private String description;
  private STATUS status;
  private double progress;
  private String acceptanceCriteria;
  private String history;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public Ticket(
      int ticketId,
      String title,
      String description,
      STATUS status,
      double progress,
      String acceptanceCriteria,
      String history,
      Timestamp createdAt,
      Timestamp updatedAt) {
    this.id = ticketId;
    this.title = title;
    this.description = description;
    this.status = status;
    this.progress = progress;
    this.acceptanceCriteria = acceptanceCriteria;
    this.history = history;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public STATUS getStatus() {
    return status;
  }

  public void setStatus(STATUS status) {
    this.status = status;
  }

  public double getProgress() {
    return progress;
  }

  public void setProgress(double progress) {
    this.progress = progress;
  }

  public String getAcceptanceCriteria() {
    return acceptanceCriteria;
  }

  public void setAcceptanceCriteria(String acceptanceCriteria) {
    this.acceptanceCriteria = acceptanceCriteria;
  }

  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
