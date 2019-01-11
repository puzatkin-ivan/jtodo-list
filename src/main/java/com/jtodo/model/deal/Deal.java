package com.jtodo.model.deal;

public class Deal implements IDeal {
    private final int id;
    private String name;
    private String status;

    public Deal(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name + ' ' + this.status + '\n');
    }
}
