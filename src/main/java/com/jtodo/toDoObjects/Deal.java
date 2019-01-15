package com.jtodo.toDoObjects;

import com.jtodo.status.IStatus;
import com.jtodo.status.InProcess;

public class Deal implements IDeal {
    private String name;
    private final IStatus status;

    public Deal() {
        name = "Undefined";
        status = new InProcess();
    }

    public Deal(String name) {
        this.name = name;
        this.status = new InProcess();
    }

    public Deal(String name, IStatus status) {
        this.name = name;
        this.status = status;
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
    public void createDeal(String dealName) throws Exception {
        throw new Exception("Sorry, but you can't create deal here.");
    }

    @Override
    public void deleteList(int listNum) throws Exception {
        throw new Exception("Sorry, but you can't delete list here.");
    }

    @Override
    public void deleteDeal(int dealNum) throws Exception {
        throw new Exception("Sorry, but you can't delete deal here.");
    }

    @Override
    public void renameTo(int num, String newName) {
        //setName(newName);
    }

    @Override
    public void changeStatus(int dealNum, IStatus newStatus) {
        //status = newStatus;
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
        return status;
    }

    @Override
    public String toString() {
        return name + ": " + status.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IDeal) {
            Deal deal = (Deal) obj;
            return deal.getName().equals(this.getName());
        }

        return false;
    }
}