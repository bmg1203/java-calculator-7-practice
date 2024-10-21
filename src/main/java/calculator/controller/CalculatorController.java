package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
    }
    public void start() {
        try {
            String input = inputView.getInput();
            int result = calculator.add(input);
            outputView.displayResult(result);
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e.getMessage());
            throw e;
        }
    }
}
