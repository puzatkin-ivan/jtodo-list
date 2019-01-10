package com.jtodo.view;

import com.jtodo.toDoObjects.*;

public interface IViewController {
    void addToViewer(IToDoObject newObj);
    void deleteLastView();
    IToDoObject getLast();
    void display();
    boolean empty();
}
