package com.timehub;

public enum STATUS {
  OPEN("Open"),
  PROCESSING("Processing"),
  CLOSED("Closed");

  private final String description;

  STATUS(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
