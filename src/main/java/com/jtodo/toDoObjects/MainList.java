package com.jtodo.toDoObjects;

import com.jtodo.status.IStatus;

import java.util.ArrayList;
import java.util.List;

public class MainList implements IMainList {
    private static final String EMPTY_MSG = "Sorry, but your's todo lists are missing.\nDon't worry, because you can create them right now!";
    private List<IToDoList> lists;

    public MainList() {
        lists = new ArrayList<>();
    }

    public MainList(List<IToDoList> lists) {
        this.lists = new ArrayList<>();
        this.lists = lists;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            res.append(i + 1);
            res.append(". ");
            res.append(lists.get(i).getName());
            res.append('\n');
        }

        if (res.toString().equals("")) {
            res = new StringBuilder(EMPTY_MSG);
        }

        return res.toString();
    }

    @Override
    public IToDoObject openList(int num) {
        num--;
        if (num < lists.size() && num >= 0) {
            return lists.get(num);
        }

        return null;
    }

    @Override
    public void createList(String listName) {
        lists.add(new ToDoList(listName));
    }

    @Override
    public void createDeal(String dealName) throws Exception {
        throw new Exception("Sorry, but you can't create deal here.");
    }

    @Override
    public void deleteList(int listNum) throws Exception {
        listNum--;
        if (listNum >= lists.size()) {
            throw new Exception("List isn't exists.");
        }
        lists.remove(listNum);
    }

    @Override
    public void deleteDeal(int dealNum) throws Exception {
        throw new Exception("Sorry, but you can't delete deal here.");
    }

    @Override
    public void renameTo(int num, String newName) {
        num--;
        if (num < lists.size()) {
            lists.get(num).setName(newName);
        }
    }

    @Override
    public void changeStatus(int dealNum, IStatus newStatus) throws Exception {
        throw new Exception("Sorry, but you can't change status here.");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public IStatus getStatus() {
        return null;
    }

    @Override
    public List<IToDoList> getLists() {
        return lists;
    }

    @Override
    public void addList(IToDoList list) {
        lists.add(list);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MainList) {
            MainList list = (MainList) obj;
            return list.getLists().equals(this.getLists());
        }
        return false;
    }
}