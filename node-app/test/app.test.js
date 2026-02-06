const { expect } = require('chai');
const App = require('../src/app');

describe('App', () => {
    let app;
    
    beforeEach(() => {
        app = new App();
    });
    
    describe('getGreeting()', () => {
        it('should return correct greeting', () => {
            expect(app.getGreeting()).to.equal('Hello World!');
        });
        
        it('should not return null or undefined', () => {
            expect(app.getGreeting()).to.not.be.null;
            expect(app.getGreeting()).to.not.be.undefined;
        });
    });
});