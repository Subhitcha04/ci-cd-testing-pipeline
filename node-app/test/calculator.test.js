const { expect } = require('chai');
const Calculator = require('../src/calculator');

describe('Calculator', () => {
    let calculator;
    
    beforeEach(() => {
        calculator = new Calculator();
    });
    
    describe('add()', () => {
        it('should add two positive numbers correctly', () => {
            expect(calculator.add(2, 3)).to.equal(5);
        });
        
        it('should handle negative numbers', () => {
            expect(calculator.add(-5, 5)).to.equal(0);
            expect(calculator.add(-5, -5)).to.equal(-10);
        });
    });
    
    describe('subtract()', () => {
        it('should subtract two numbers correctly', () => {
            expect(calculator.subtract(3, 2)).to.equal(1);
        });
        
        it('should handle negative results', () => {
            expect(calculator.subtract(-5, 5)).to.equal(-10);
            expect(calculator.subtract(5, 5)).to.equal(0);
        });
    });
    
    describe('multiply()', () => {
        it('should multiply two numbers correctly', () => {
            expect(calculator.multiply(2, 3)).to.equal(6);
            expect(calculator.multiply(0, 5)).to.equal(0);
            expect(calculator.multiply(5, 5)).to.equal(25);
        });
    });
    
    describe('divide()', () => {
        it('should divide two numbers correctly', () => {
            expect(calculator.divide(10, 5)).to.equal(2);
            expect(calculator.divide(5, 2)).to.equal(2.5);
        });
        
        it('should throw error when dividing by zero', () => {
            expect(() => calculator.divide(10, 0)).to.throw('Cannot divide by zero');
        });
    });
});