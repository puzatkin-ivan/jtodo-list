package com.jtodo.model.list;

import com.jtodo.model.deal.IDeal;
import java.util.List;

public interface IList {
    public int getListId();
    public void setName(String name);
    public String getName();

    public List<IDeal> getDeals();
    public void addDeal(IDeal task);

    public String toString();
    public String toStringDeals();
    public String toJSON();
}