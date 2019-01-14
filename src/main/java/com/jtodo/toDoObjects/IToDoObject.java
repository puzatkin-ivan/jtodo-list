package com.jtodo.toDoObjects;

import com.jtodo.status.*;

public interface IToDoObject {
    IToDoObject openList(int num);
    void createList(String listName);
    void createDeal(String dealName);
    void deleteList(int listNum) throws Exception;
    void deleteDeal(int dealNum) throws Exception;
    void renameTo(int num, String newName);
    void changeStatus(int dealNum, IStatus newStatus);
    void setName(String name);
    String getName();
    IStatus getStatus();
    String toString();
}
