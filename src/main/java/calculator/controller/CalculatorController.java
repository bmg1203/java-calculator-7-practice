package calculator.controller;

import calculator.model.Calculator;
import calculator.parser.DelimiterParser;
import calculator.parser.InputParser;
import calculator.parser.NumberConverter;
import calculator.validator.Validator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        this.calculatorView = new CalculatorView();
        Validator validator = new Validator();
        DelimiterParser delimiterParser = new DelimiterParser();
        NumberConverter numberConverter = new NumberConverter();
        InputParser inputParser = new InputParser(delimiterParser, numberConverter, validator);
        this.calculator = new Calculator(inputParser, validator);
    }


    public void run() {
        String input = calculatorView.getInput();
        int result = calculator.calculate(input);
        calculatorView.displayResult(result);
    }//run
}//class
