// Read from environment variables
const API_KEY = process.env.API_KEY;
const DB_PASSWORD = process.env.DB_PASSWORD;

class App {
    constructor() {}

    getGreeting() {
        return "Hello, World!";
    }

    riskyFunction() {
        try {
            let x = null;
            x.toString();
        } catch (e) {
            console.error("Error in riskyFunction:", e.message);
        }
    }
}

module.exports = App;