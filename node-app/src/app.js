// ★ HARDCODED SECRET — will trigger Vulnerability ★
const API_KEY = "hardcoded-secret-key-12345";
const DB_PASSWORD = "supersecretpassword123";

// ★ EMPTY CATCH — will trigger a Bug ★
function riskyFunction() {
    try {
        let x = null;
        x.toString();
    } catch (e) {
        // empty catch block - intentional bug for testing
    }
}

riskyFunction();