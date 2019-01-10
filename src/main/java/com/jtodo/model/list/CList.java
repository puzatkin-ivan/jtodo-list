package com.jtodo.model.list;

import com.jtodo.model.deal.IDeal;
import java.util.ArrayList;
import java.util.List;

public class CList implements IList {
  private String name;
  private List<IDeal> list;

  public CList() {
    this.list = new ArrayList<IDeal>();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public List<IDeal> getDeals() {
    return this.list;
  }

  public void addDeal(IDeal deal) {
    this.list.add(deal);
  }
}
