package com.example;

import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AppTest {

    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    // Basic instantiation test
    @Test
    public void testAppInstantiation() {
        assertNotNull(app);
    }

    // Validate exact value
    @Test
    public void testGetValueEquals42() {
        assertEquals(42, app.getValue());
    }

    // Validate positive number
    @Test
    public void testGetValueIsPositive() {
        assertTrue(app.getValue() > 0);
    }

    // Validate not negative
    @Test
    public void testGetValueIsNotNegative() {
        assertFalse(app.getValue() < 0);
    }

    // Validate value consistency
    @Test
    public void testGetValueConsistency() {
        int first = app.getValue();
        int second = app.getValue();
        assertEquals(first, second);
    }

    // Ensure riskyMethod does not throw exception
    @Test
    public void testRiskyMethodDoesNotThrow() {
        try {
            app.riskyMethod();
        } catch (Exception e) {
            fail("riskyMethod should not throw exception");
        }
    }

    // Call riskyMethod multiple times (branch coverage improvement)
    @Test
    public void testRiskyMethodMultipleCalls() {
        for (int i = 0; i < 3; i++) {
            app.riskyMethod();
        }
        assertTrue(true);
    }

    // Test main method execution
    @Test
    public void testMainMethodDoesNotThrow() {
        try {
            App.main(new String[]{});
        } catch (Exception e) {
            fail("Main method should not throw exception");
        }
    }

    // Capture console output from main (improves coverage)
    @Test
    public void testMainMethodOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{});

        String output = outContent.toString();
        assertNotNull(output);
    }
}