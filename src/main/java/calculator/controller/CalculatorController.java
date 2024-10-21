package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final Calculator calculator;
    private final Extractor extractor;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.extractor = new Extractor();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {

        String input = inputView.read();
        inputView.close();

        extractor.extractCustomDelimiter(input);
        List<Long> numbers = extractor.extractNumbers(input);

        long result = calculator.calculateSum(numbers);

        outputView.print(result);
    }
}
