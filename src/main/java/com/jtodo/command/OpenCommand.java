package com.jtodo.command;

import com.jtodo.command.exception.*;
import com.jtodo.view.IView;

public class OpenCommand implements ICommand {
    private static final int ARGUMENT_COUNT = 2;

    private final IView view;

    public OpenCommand(IView view) {
        this.view = view;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        if (args.length != ARGUMENT_COUNT) {
            throw new CommandException("Error: Invalid count of argument.\nUse: open <number>\n ");
        }
    }
}
