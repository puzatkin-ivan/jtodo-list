package com.jtodo.status;

public class Status implements IStatus {
    private String name;

    public Status(String statusName) {
        name = statusName;
    }

    @Override
    public String toString() {
        return name;
    }
}
