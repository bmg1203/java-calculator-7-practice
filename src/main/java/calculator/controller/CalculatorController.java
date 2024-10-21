package calculator.controller;

import calculator.model.Calculator;
import calculator.model.RegDelimiter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Calculator calculator = postCalculator();
        getCalculator(calculator);
    }

    private Calculator postCalculator() {
        String inputValue = inputView.inputValue();
        RegDelimiter regDelimiter = new RegDelimiter();
        regDelimiter.registerCustomDelimiter(inputValue);
        return new Calculator(inputValue, regDelimiter);
    }

    private void getCalculator(Calculator calculator) {
        calculator.calculate();
        outputView.outputResult(calculator);
    }
}
