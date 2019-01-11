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

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName(String name) {
        this.name = name;
        return this.name;
    }

    @Override
    public List<IList> getLists() {
        return this.list;
    }

    @Override
    public void addList(IList list) {
        this.list.add(list);
    }

    @Override
    public IList getList(int index) {
        return this.list.get(index);
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    public String toString() {
        StringBuilder bundle = new StringBuilder();
        for (IList list : this.list) {
            bundle.append(list.toString());
        }
        return bundle.toString();
    }
}