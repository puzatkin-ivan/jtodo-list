package com.jtodo;

import com.jtodo.command.*;
import com.jtodo.model.storage.*;

import java.util.*;

public class Main {
    public static void main(String[] $args) {
        try {
            IStorage storage = new Storage();
            Scanner inStream = new Scanner(System.in);
            String path = "";

            CApplication app = new CApplication(inStream, System.out, path, storage);
            app.setCommands(init(app));
            app.doExecute();
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    private static Map<String, ICommand> init(IApplication app) {
        Map<String, ICommand> commands = new HashMap<String, ICommand>();
        commands.put("create_list", new CreateListCommand(app));
        commands.put("show_list", new ShowListCommand(app));
        commands.put("exit", new ExitCommand(app));
        return commands;
    }
}
