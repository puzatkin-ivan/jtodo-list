package com.jtodo.status;

public class Status implements IStatus {
    private final String name;

    public Status(String statusName) {
        name = statusName;
    }

    @Override
    public String toString() {
        return name;
    }
}
