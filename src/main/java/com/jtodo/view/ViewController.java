package com.jtodo.view;

import com.jtodo.toDoObjects.IToDoObject;

import java.util.Stack;

public class ViewController implements IViewController {
    private final Stack<IToDoObject> obj = new Stack<>();

    @Override
    public void addToViewer(IToDoObject newObj) {
        obj.add(newObj);
    }

    @Override
    public void deleteLastView() {
        obj.pop();
    }

    @Override
    public IToDoObject getLast() {
        return obj.peek();
    }

    @Override
    public void display() {
        if (obj.size() > 0) {
            System.out.println(obj.peek());
        }
    }

    @Override
    public boolean empty() {
        return obj.empty();
    }
}
