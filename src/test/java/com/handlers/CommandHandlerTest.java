package com.handlers;

import com.jtodo.handlers.CommandHandler;
import com.jtodo.handlers.ICommandHandler;
import com.jtodo.toDoObjects.IMainList;
import com.jtodo.toDoObjects.MainList;
import com.jtodo.view.IViewController;
import com.jtodo.view.ViewController;
import org.junit.Before;
import org.junit.Test;

import static com.jtodo.command.utils.CommandUtils.getCommands;
import static org.junit.Assert.assertTrue;

public class CommandHandlerTest {
    private ICommandHandler commandHandler;

    @Before
    public void init() {
        IMainList mainList = new MainList();
        IViewController viewController = new ViewController();
        commandHandler = new CommandHandler(getCommands(viewController));
        viewController.addToViewer(mainList);

    }

    @Test
    public void canHandCreateListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
    }

    @Test
    public void canHandOpenListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("open 1"));
    }

    @Test
    public void canHandCreateDealCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("open 1"));
        assertTrue(commandHandler.handleCommand("create deal new deal"));
    }

    @Test
    public void canHandRenameCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("rename 1 New name"));
    }

    @Test
    public void canHandDeleteDealCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("open 1"));
        assertTrue(commandHandler.handleCommand("create deal new deal"));
        assertTrue(commandHandler.handleCommand("delete deal 1"));
    }

    @Test
    public void canHandDeleteListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("delete list 1"));
    }

    @Test
    public void canHandExitCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("open 1"));
        assertTrue(commandHandler.handleCommand("exit"));
    }

    @Test
    public void canHandChangeCommand() {
        assertTrue(commandHandler.handleCommand("create list Test"));
        assertTrue(commandHandler.handleCommand("open 1"));
        assertTrue(commandHandler.handleCommand("create deal new deal"));
        assertTrue(commandHandler.handleCommand("change status 1 completed"));
        assertTrue(commandHandler.handleCommand("change status 1 process"));
    }

}
