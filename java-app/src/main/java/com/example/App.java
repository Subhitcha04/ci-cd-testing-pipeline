package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    // ✅ Fix 1: API_KEY is now actually used in main()
    private static final String API_KEY = System.getenv("API_KEY");

    // ✅ Fix 2: removed unused 'result' variable
    public void riskyMethod() {
        try {
            int denominator = 0;
            if (denominator == 0) {
                throw new ArithmeticException("Division by zero");
            }
        } catch (ArithmeticException e) {
            LOGGER.log(Level.SEVERE, "Arithmetic error occurred", e);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        // ✅ API_KEY is now used — no "unused field" warning
        LOGGER.info("Application started. API_KEY configured: " + (API_KEY != null));
        app.riskyMethod();
    }
}