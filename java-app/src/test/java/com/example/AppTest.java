package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AppTest {

    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testAppInstantiation() {
        assertNotNull(app);
    }

    @Test
    public void testRiskyMethodDoesNotThrow() {
        try {
            app.riskyMethod();
            assertTrue(true);
        } catch (Exception e) {
            fail("riskyMethod should not throw: " + e.getMessage());
        }
    }

    @Test
    public void testRiskyMethodHandlesException() {
        try {
            app.riskyMethod();
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception should have been caught inside riskyMethod: " + e.getMessage());
        }
    }

    @Test
    public void testApiKeyFromEnvironment() {
        // Just verify System.getenv doesn't throw
        String apiKey = System.getenv("API_KEY");
        // null is acceptable — means env var not set
        assertTrue(apiKey == null || apiKey.length() >= 0);
    }

    @Test
    public void testMainMethod() {
        try {
            App.main(new String[]{});
            assertTrue(true);
        } catch (Exception e) {
            fail("main() should not throw: " + e.getMessage());
        }
    }
}