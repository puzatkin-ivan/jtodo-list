package com.jtodo;

import com.jtodo.model.storage.IStorage;

public interface IApplication {
    public void setState(ApplicationState state);
    public IStorage getStorage();
    void exit();
}
