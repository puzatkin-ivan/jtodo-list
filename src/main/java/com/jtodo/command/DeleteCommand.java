package com.jtodo.command;

import com.jtodo.view.IViewController;

import static com.jtodo.command.utils.CommandUtils.*;

public class DeleteCommand implements ICommand {
    private final IViewController viewer;

    public DeleteCommand(IViewController viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args[1].equals(LIST)) {
            viewer.getLast().deleteList(Integer.parseInt(args[2]));
        } else if (args[1].equals(DEAL)) {
            viewer.getLast().deleteDeal(Integer.parseInt(args[2]));
        } else {
            throw new Exception(INVALID_COMMAND_ERROR_MSG + DELETE_USAGE_EXAMPLE);
        }
    }
}
