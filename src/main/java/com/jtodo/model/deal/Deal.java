package com.jtodo.model.deal;

public class Deal implements IDeal {
  private String name;
  private String status;

  public void setName(String name) {
    this.name = name;
  }

  public String getName(String name) {
    return this.name;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }
}
