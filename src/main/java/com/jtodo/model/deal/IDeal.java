package com.jtodo.model.deal;

public interface IDeal {
  public int getId();
  public void setName(String name);
  public String getName();

  public void setStatus(String status);
  public String getStatus();

  public String toString();
}