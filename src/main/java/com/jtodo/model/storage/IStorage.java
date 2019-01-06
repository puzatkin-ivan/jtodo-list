package com.jtodo.model.storage;

import com.jtodo.model.list.IList;
import java.util.List;

public interface IStorage {
  public void setName(String name);
  public String getName(String name);

  public List<IList> getList();
  public void addList(IList list);
}