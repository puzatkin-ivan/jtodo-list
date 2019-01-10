package com.jtodo.handlers;

import com.jtodo.view.*;

public interface ICommandHandler {
    boolean handleCommand(String command, IViewController viewer);
}
