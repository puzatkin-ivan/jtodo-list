package com.jtodo;

import com.jtodo.command.*;
import com.jtodo.handlers.*;
import com.jtodo.toDoObjects.*;
import com.jtodo.view.*;
import com.jtodo.workWithFiles.*;

import java.io.File;
import java.util.*;

import static com.jtodo.command.utils.CommandUtils.*;

public class Main {

    static IMainList loadFiles(IDataWorker worker, File dir) {
        IMainList list = null;
        try {
            list = worker.convertDataFromFiles(dir);
        } catch (Exception ex) {
        }

        return list;
    }

    public static void main(String[] args) {
        final String mainPath = "src/main/resources/ToDoLists";
        final String READ_POINTER = "> ";
        final String HELLO_MSG = "Hello! Welcome to jtodo-list.";
        final String EXIT_MSG = "Thank you, Goodbye!";
        final String LIST_MSG = "Your todo-list:";

        File dir = new File(mainPath);
        if (!dir.exists()) {
            System.out.println("Sorry, but directory \"" + dir.toString() + "\" is not exists.");
            return;
        }

        IDataWorker dWorker = new DataWorker();
        IMainList mainList = loadFiles(dWorker, dir);

        if (mainList == null) {
            System.out.println("Failed to load files.");
            return;
        }

        ViewController viewer = new ViewController();
        viewer.addToViewer(mainList);

        Scanner in = new Scanner(System.in);
        ICommandHandler handler = new CommandHandler(initCommand(viewer));

        Timer timer = new Timer();
        IMainList timerMainList = mainList;
        TimerTask autoSave = new TimerTask() {
            public void run() {
                try {
                    dWorker.deleteDifferences(mainList, dir);
                    dWorker.convertDataToFiles(timerMainList, dir);
                } catch (Exception e) {
                    System.out.println("Auto save process failed.");
                }
            }
        };
        timer.schedule(autoSave, 5000, 10000);

        System.out.println(HELLO_MSG);
        System.out.println();
        while (!viewer.empty()) {
            System.out.println(LIST_MSG);
            viewer.display();
            System.out.print(READ_POINTER);
            String command = in.nextLine();
            handler.handleCommand(command, viewer);
        }

        timer.cancel();
        try {
            dWorker.convertDataToFiles(mainList, dir);
        } catch (Exception ex) {
            System.out.println("Failed to save files, last saved version of files was saved.");
        }
        System.out.println(EXIT_MSG);
    }

    private static Map<String, ICommand> initCommand(IViewController viewer) {
        Map<String, ICommand> commands = new HashMap<>();
        commands.put(OPEN_COMMAND, new OpenCommand(viewer));
        commands.put(CREATE_COMMAND, new CreateCommand(viewer));
        commands.put(CHANGE_COMMAND, new ChangeCommand(viewer));
        commands.put(DELETE_COMMAND, new DeleteCommand(viewer));
        commands.put(RENAME_COMMAND, new RenameCommand(viewer));
        commands.put(EXIT_COMMAND, new ExitCommand(viewer));
        return commands;
    }
}