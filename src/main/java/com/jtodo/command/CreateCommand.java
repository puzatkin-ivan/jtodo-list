package com.jtodo.command;

import com.jtodo.command.utils.CommandUtils;
import com.jtodo.view.IViewController;

import static com.jtodo.command.utils.CommandUtils.*;

public class CreateCommand implements ICommand {
    private final IViewController viewer;

    public CreateCommand(IViewController viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute(String[] commandArr) throws Exception {
        if (commandArr.length != MIN_CREATE_COMMAND_SIZE) {
            throw new Exception(ARGS_COUNT_ERROR_MSG + CREATE_USAGE_EXAMPLE);
        }

        String commandArgs = CommandUtils.findCommandArgs(commandArr, 2, commandArr.length);
        switch (commandArr[1]) {
            case LIST:
                viewer.getLast().createList(commandArgs);
                break;
            case DEAL:
                viewer.getLast().createDeal(commandArgs);
                break;
            default:
                throw new Exception(INVALID_COMMAND_ERROR_MSG + CREATE_USAGE_EXAMPLE);
        }
    }
}
