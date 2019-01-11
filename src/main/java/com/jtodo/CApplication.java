package com.jtodo;

import com.jtodo.command.*;
import com.jtodo.command.exception.CommandException;
import com.jtodo.model.storage.IStorage;
import com.jtodo.view.IView;

import java.io.PrintStream;
import java.util.*;

class CApplication implements IApplication {
    private static final String DELIMETER_COMMAND = " ";

    private String path;
    private IStorage storage;
    private Scanner stream;
    private Map<String, ICommand> commands;
    private IView view;
    private ApplicationState state;
    private ApplicationWatcher watcher;

    CApplication(Scanner stream, PrintStream printStream, String path, IStorage storage) {
        this.path = path;
        this.storage = storage;
        this.stream = stream;
        this.commands = new HashMap<String, ICommand>();
        this.watcher = new ApplicationWatcher(printStream);
        open();
    }

    void setCommands(Map<String, ICommand> newCommands) {
        this.commands.putAll(newCommands);
    }

    void setCommand(String name, ICommand command) {
        this.commands.put(name, command);
    }

    void doExecute() throws Exception {
        String commandStr;
        while (this.state == ApplicationState.Open) {
            try {
                commandStr = readNextCommand();
                executeCommand(commandStr);
            } catch (CommandException ex) {
                this.watcher.printMessage(ex.getMessage());
            }
        }
    }

    private String readNextCommand() {
        this.watcher.handleNextCommand();
        return this.stream.nextLine();
    }

    private void executeCommand(String commandStr) {
        String[] args = commandStr.split(DELIMETER_COMMAND);

        if (!this.commands.containsKey(args[0])) {
            throw new CommandException("Error: Invalid command\n");
        }

        ICommand command = this.commands.get(args[0]);
        command.execute(args);
    }

    @Override
    public void setState(ApplicationState state) {
        this.state = state;
    }

    @Override
    public IStorage getStorage() {
        return this.storage;
    }

    public void open() {
        this.state = ApplicationState.Open;
        this.watcher.handleOpened();
    }

    @Override
    public void exit() {
        this.state = ApplicationState.Exit;
        this.watcher.handleClosed();
    }
}
