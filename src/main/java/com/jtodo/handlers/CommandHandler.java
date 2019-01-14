package com.jtodo.handlers;

import com.jtodo.command.ICommand;
import com.jtodo.view.*;

import java.util.*;

import static com.jtodo.command.utils.CommandUtils.*;

public class CommandHandler implements ICommandHandler {
    private final Map<String, ICommand> commands;

    public CommandHandler(Map<String, ICommand> commands) {
        this.commands = commands;
    }

    @Override
    public boolean handleCommand(String commandLine, IViewController viewer) {
        boolean result = true;
        String[] commandArr = commandLine.split(" ");
        try {
            if (commandArr.length < MIN_COMMAND_SIZE) {
                throw new Exception(UNKNOWN_COMMAND_ERROR_MSG);
            }

            if (!this.commands.containsKey(commandArr[0])) {
                throw new Exception(UNKNOWN_COMMAND_ERROR_MSG);
            }
            ICommand command = this.commands.get(commandArr[0]);
            command.execute(commandArr);
        } catch (NumberFormatException ex) {
            System.out.println(NUMBER_PARSE_ERROR_MSG + ex.getMessage());
            result = false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            result = false;
        }
        return result;
    }
}