package com.example;

import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public void riskyMethod() {
        // Clean method — no exceptions, no unused variables
        int value = getValue();
        logger.info("Value: " + value);
    }

    public int getValue() {
        return 42;
    }

    public static void main(String[] args) {
        App app = new App();
        app.riskyMethod();
        logger.info("Application started successfully.");
    }
}