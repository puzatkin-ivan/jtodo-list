package com.jtodo;

import com.jtodo.command.*;
import com.jtodo.command.exception.CommandException;
import com.jtodo.model.storage.IStorage;
import com.jtodo.view.IView;

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

    CApplication(Scanner stream, String path, IStorage storage) {
        this.path = path;
        this.storage = storage;
        this.stream = stream;
        this.commands = new HashMap<String, ICommand>();
        this.watcher = new ApplicationWatcher(System.out);
        init();
        open();
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

    private void init() {
        /*this.commands.put("open", new OpenCommand(this.view));
        this.commands.put("create", new CreateCommand(this.view));
        this.commands.put("rename", new RenameCommand(this.view));
        this.commands.put("change", new ChangeCommand(this.view));
        this.commands.put("delete", new DeleteCommand(this.view));*/
        this.commands.put("exit", new ExitCommand(this));
    }

    @Override
    public void setState(ApplicationState state) {
        this.state = state;
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
