package com.jtodo.model.storage;

import com.jtodo.model.list.IList;
import java.util.ArrayList;
import java.util.List;

public class Storage implements IStorage {
  private String name;
  private List<IList> list;

  public Storage() {
    this.list = new ArrayList<IList>();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName(String name) {
    return this.name;
  }

  public List<IList> getList() {
    return this.list;
  }

  public void addList(IList list) {
    this.list.add(list);
  }
}