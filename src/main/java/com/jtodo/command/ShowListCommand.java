package com.jtodo.command;

import com.jtodo.IApplication;
import com.jtodo.command.exception.CommandException;

public class ShowListCommand implements ICommand {
    private IApplication app;

    public ShowListCommand(IApplication app) {
        this.app = app;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        int index = Integer.parseInt(args[1]);
    }
}