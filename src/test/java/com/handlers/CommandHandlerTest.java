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
    private IViewController viewController;

    @Before
    public void init() {
        IMainList mainList = new MainList();
        viewController = new ViewController();
        commandHandler = new CommandHandler(getCommands(viewController));
        viewController.addToViewer(mainList);

    }

    @Test
    public void canHandCreateListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
    }

    @Test
    public void canHandOpenListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
    }

    @Test
    public void canHandCreateDealCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("create deal new deal", viewController));
    }

    @Test
    public void canHandRenameCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("rename 1 New name", viewController));
    }

    @Test
    public void canHandDeleteDealCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("create deal new deal", viewController));
        assertTrue(commandHandler.handleCommand("delete deal 1", viewController));
    }

    @Test
    public void canHandDeleteListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("delete list 1", viewController));
    }

    @Test
    public void canHandExitCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("exit", viewController));
    }

    @Test
    public void canHandChangeCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("create deal new deal", viewController));
        assertTrue(commandHandler.handleCommand("change status 1 completed", viewController));
        assertTrue(commandHandler.handleCommand("change status 1 process", viewController));
    }

}
