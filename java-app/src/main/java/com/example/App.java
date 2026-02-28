package com.example; 
public class App {

    // ✅ FIX 1: Read from environment variable instead of hardcoding
    private static final String API_KEY = System.getenv("API_KEY");

    // ✅ FIX 2: Always log or handle the exception — never leave catch empty
    public void riskyMethod() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}