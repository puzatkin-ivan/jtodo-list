package view;

import toDoObjects.IToDoObject;

public interface IViewController {
    void addToViewer(IToDoObject newObj);
    void deleteLastView();
    IToDoObject getLast();
    void display();
    boolean empty();
}
