package com.jtodo.command;

import com.jtodo.IApplication;
import com.jtodo.command.exception.*;

public class ExitCommand implements ICommand {
    private final IApplication app;

    public ExitCommand(IApplication app) {
        this.app = app;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        this.app.exit();
    }
}
