package com.jtodo.toDoObjects;

import com.jtodo.status.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList implements IToDoList {
    final String EMPTY_LIST = "Sorry, but your todo list is empty.\nDon't worry, because you can create deals right now!";
    private String name;
    private List<IDeal> deals = new ArrayList<>();

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
    public void createList(String listName) {
        System.out.println("Sorry, but you can't create list here.");
    }

    @Override
    public void createDeal(String dealName) {
        deals.add(new Deal(dealName));
    }

    @Override
    public void deleteList(int listNum) {
        System.out.println("Sorry, but you can't delete list here.");
    }

    @Override
    public void deleteDeal(int dealNum) {
        dealNum--;
        if(dealNum < deals.size()) {
            deals.remove(dealNum);
        }
    }

    @Override
    public void renameTo(int num, String newName) {
        IDeal changedDeal = new Deal(newName);
        num--;
        deals.remove(num);
        deals.add(num, changedDeal);
    }

    @Override
    public void changeStatus(int dealNum, IStatus newStatus) {
        dealNum--;
        IDeal changedDeal = new Deal(deals.get(dealNum).getName(), newStatus);
        deals.remove(dealNum);
        deals.add(dealNum, changedDeal);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IStatus getStatus() {
        return null;
    }

    @Override
    public String toString() {
        String res = name;
        res += '\n';
        for(int i = 0; i < deals.size(); i++) {
            res += (i + 1);
            res += ". ";
            res += deals.get(i).getName();
            res += ": ";
            res += deals.get(i).getStatus();
            res += '\n';
        }
        if(res.equals(name + '\n')) {
            res += EMPTY_LIST;
        }
        return res;
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
        if(obj instanceof ToDoList) {
            ToDoList list = (ToDoList) obj;
            return (list.getName().equals(this.getName())) && (list.getDeals().equals(this.getDeals()));
        }
        return false;
    }
}