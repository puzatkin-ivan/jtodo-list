package com.jtodo.command;
import com.jtodo.command.exception.*;

public interface ICommand {
    public void execute(String[] args) throws CommandException;
}
