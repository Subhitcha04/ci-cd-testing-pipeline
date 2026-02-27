public class App {
    // ★ HARDCODED SECRET — will trigger Vulnerability ★
    private static final String API_KEY = "hardcoded-secret-key-12345";

    // ★ EMPTY CATCH BLOCK — will trigger a Bug ★
    public void riskyMethod() {
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            // empty catch - SonarQube detects this as a bug
        }
    }

    public static void main(String[] args) {
        System.out.println("This is devops CI/CD pipeline testing");
    }
}