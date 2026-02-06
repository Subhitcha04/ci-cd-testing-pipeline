# CI Testing Demo

This repository demonstrates automated unit testing and CI/CD quality gates using both Java and Node.js applications.

## Project Structure
```
ci-testing-demo/
├── java-app/          # Java application with JUnit tests
└── node-app/          # Node.js application with Mocha/Chai tests
```

## Java Application

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Running Tests
```bash
cd java-app
mvn test
```

### Running Application
```bash
mvn compile exec:java -Dexec.mainClass="com.example.App"
```

## Node.js Application

### Prerequisites
- Node.js 14 or higher
- npm

### Setup
```bash
cd node-app
npm install
```

### Running Tests
```bash
npm test
```

### Running Application
```bash
npm start
```

## CI/CD Pipeline

Both applications have Jenkins pipelines configured that:
1. Check out code from repository
2. Build the application
3. Run automated unit tests
4. Publish test results
5. Fail the build if any tests fail (Quality Gate)

## Demonstrating Quality Gate

To see the quality gate in action:

### Java:
Edit `java-app/src/test/java/com/example/CalculatorTest.java` and change:
```java
assertEquals(5, calculator.add(2, 3));
```
to:
```java
assertEquals(10, calculator.add(2, 3)); // This will fail!
```

### Node.js:
Edit `node-app/test/calculator.test.js` and change:
```javascript
expect(calculator.add(2, 3)).to.equal(5);
```
to:
```javascript
expect(calculator.add(2, 3)).to.equal(10); // This will fail!
```

Commit and push - the build will fail, demonstrating the quality gate.

## License
MIT