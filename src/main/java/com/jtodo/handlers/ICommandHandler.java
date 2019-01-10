package handlers;

import view.IViewController;

public interface ICommandHandler {
    boolean handleCommand(String command, IViewController viewer);
}
