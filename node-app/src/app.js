const Calculator = require('./calculator');

class App {
    constructor() {
        this.calculator = new Calculator();
    }
    
    getGreeting() {
        return 'Hello World!';
    }
    
    run() {
        console.log('Hello from Node.js CI Demo!');
        console.log('2 + 3 =', this.calculator.add(2, 3));
        console.log('5 - 2 =', this.calculator.subtract(5, 2));
        console.log('4 * 3 =', this.calculator.multiply(4, 3));
        console.log('10 / 2 =', this.calculator.divide(10, 2));
    }
}

// Run the app if this file is executed directly
if (require.main === module) {
    const app = new App();
    app.run();
}

module.exports = App;