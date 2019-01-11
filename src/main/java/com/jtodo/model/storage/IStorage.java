package com.jtodo.model.storage;

import com.jtodo.model.list.IList;
import java.util.List;

public interface IStorage {
  public void setName(String name);
  public String getName(String name);

  public List<IList> getLists();
  public void addList(IList list);
  public IList getList(int index);
  public int getSize();
}