package com.jtodo.toDoObjects;

import com.jtodo.status.IStatus;

public interface IToDoObject {
    IToDoObject openList(int num);

    void createList(String listName) throws Exception;

    void createDeal(String dealName) throws Exception;

    void deleteList(int listNum) throws Exception;

    void deleteDeal(int dealNum) throws Exception;

    void renameTo(int num, String newName);

    void changeStatus(int dealNum, IStatus newStatus);

    String getName();

    void setName(String name);

    IStatus getStatus();

    String toString();
}
