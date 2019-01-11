package com.jtodo.model.list;

import com.jtodo.model.deal.IDeal;
import java.util.ArrayList;
import java.util.List;

public class CList implements IList {
    private final int id;
    private String name;
    private List<IDeal> list;

    public CList(int id) {
        this.id = id;
        this.list = new ArrayList<IDeal>();
    }

    @Override
    public int getListId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<IDeal> getDeals() {
        return this.list;
    }

    @Override
    public void addDeal(IDeal deal) {
        this.list.add(deal);
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + '\n';
    }

    @Override
    public String toStringDeals() {
        StringBuilder bundle = new StringBuilder();
        if (this.list.isEmpty())
        {
            return "Empty list";
        }

        for (IDeal deal : this.list) {
            bundle.append(deal.toString());
        }
        return bundle.toString();
    }

    @Override
    public String toJSON() {
        return "";

    }
}
