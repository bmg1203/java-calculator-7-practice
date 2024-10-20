package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private InputView inputView;
    private OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            String input = inputView.getInputString();

            Delimiter delimiter = new Delimiter(input);
            String[] splitNumbers = delimiter.getSplitString();

            Number number = new Number(splitNumbers);
            int result = number.calculateSum();
            outputView.printResult(result);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;

        } finally {
            inputView.close();
        }
    }
}


