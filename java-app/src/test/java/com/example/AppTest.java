package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    
    @Test
    public void testGetGreeting() {
        App app = new App();
        assertEquals("Hello World!", app.getGreeting());
    }
    
    @Test
    public void testGreetingNotNull() {
        App app = new App();
        assertNotNull(app.getGreeting());
    }
}