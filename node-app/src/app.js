// ✅ FIX 1: Read from environment variables
const API_KEY = process.env.API_KEY;
const DB_PASSWORD = process.env.DB_PASSWORD;

// ✅ FIX 2: Handle the exception properly
function riskyFunction() {
    try {
        let x = null;
        x.toString();
    } catch (e) {
        console.error("Error in riskyFunction:", e.message);
    }
}

riskyFunction();