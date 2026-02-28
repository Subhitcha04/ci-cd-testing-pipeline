package com.example;

public class App {

    public void riskyMethod() {
        // Clean method — no exceptions, no unused variables
        int value = getValue();
        System.out.println("Value: " + value);
    }

    public int getValue() {
        return 42;
    }

    public static void main(String[] args) {
        App app = new App();
        app.riskyMethod();
        System.out.println("Application started successfully.");
    }
}