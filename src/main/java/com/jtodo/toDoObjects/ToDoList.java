package com.jtodo.toDoObjects;

import com.jtodo.status.IStatus;

import java.util.ArrayList;
import java.util.List;

public class ToDoList implements IToDoList {
    private static final String EMPTY_LIST = "Sorry, but your todo list is empty.\nDon't worry, because you can create deals right now!";
    private String name;
    private final List<IDeal> deals = new ArrayList<>();

    public ToDoList() {
        name = "Undefined";
    }

    public ToDoList(String name) {
        this.name = name;
    }

    @Override
    public IToDoObject openList(int num) {
        System.out.println("Sorry, but you can't open list here.");
        return null;
    }

    @Override
    public void createList(String listName) throws Exception {
        throw new Exception("Sorry, but you can't create list here.");
    }

    @Override
    public void createDeal(String dealName) {
        deals.add(new Deal(dealName));
    }

    @Override
    public void deleteList(int listNum) throws Exception {
        throw new Exception("Sorry, but you can't delete list here.");
    }

    @Override
    public void deleteDeal(int dealNum) throws Exception {
        dealNum--;
        if (dealNum >= deals.size()) {
            throw new Exception("Deal isn't exits");
        }
        deals.remove(dealNum);
    }

    @Override
    public void renameTo(int num, String newName) {
        IDeal changedDeal = new Deal(newName);
        num--;
        deals.remove(num);
        deals.add(num, changedDeal);
    }

    @Override
    public void changeStatus(int dealNum, IStatus newStatus) throws Exception {
        if (deals.size() <= --dealNum) {
            throw new Exception("Deal isn't exists.");
        }

        IDeal changedDeal = deals.get(dealNum);
        changedDeal.setStatus(newStatus);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public IStatus getStatus() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(name);
        res.append('\n');
        for (int i = 0; i < deals.size(); i++) {
            res.append(i + 1);
            res.append(". ");
            res.append(deals.get(i).getName());
            res.append(": ");
            res.append(deals.get(i).getStatus());
            res.append('\n');
        }

        if (res.toString().equals(name + '\n')) {
            res.append(EMPTY_LIST);
        }

        return res.toString();
    }

    @Override
    public List<IDeal> getDeals() {
        return deals;
    }

    @Override
    public void addDeal(IDeal deal) {
        deals.add(deal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ToDoList) {
            ToDoList list = (ToDoList) obj;
            return (list.getName().equals(this.getName())) && (list.getDeals().equals(this.getDeals()));
        }

        return false;
    }
}