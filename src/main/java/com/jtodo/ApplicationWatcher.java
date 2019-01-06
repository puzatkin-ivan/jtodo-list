package com.jtodo;

import java.io.PrintStream;

public class ApplicationWatcher {
    public static final String READ_POINTER = "> ";
    private final PrintStream stream;

    public ApplicationWatcher(PrintStream stream) {
        this.stream = stream;
    }

    public void handleOpened() {
        this.stream.println("Hello! Welcome to jtodo-list.");
        this.stream.println();
    }

    public void handleClosed() {
        stream.println("Thank you, Goodbye!");
    }

    public void handleNextCommand() {
        stream.print(READ_POINTER);
    }

    public void printMessage(String msg) {
        this.stream.println(msg);
    }
}
