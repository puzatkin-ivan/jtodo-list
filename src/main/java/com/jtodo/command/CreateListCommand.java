package com.jtodo.command;
import com.jtodo.ApplicationWatcher;
import com.jtodo.IApplication;
import com.jtodo.command.exception.*;
import com.jtodo.model.deal.*;
import com.jtodo.model.list.*;
import com.jtodo.model.storage.*;

import java.applet.Applet;
import java.util.List;

public class CreateListCommand implements ICommand {
    private IApplication app;

    public CreateListCommand(IApplication app) {
        this.app = app;
    }

    @Override
    public void execute(String[] args) throws CommandException {
       /* if (args.length ==  2) {
            IList list = new CList(this.storage.getSize() + 1);
            list.setName(args[1]);
            this.storage.addList(list);
        }
        watcher.printMessage(this.storage.toString());*/
    }
}
