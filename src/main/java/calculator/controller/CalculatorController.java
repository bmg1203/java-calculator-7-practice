package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(CalculatorService calculatorService, InputView inputView, OutputView outputView) {
        this.calculatorService = calculatorService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.getInput();
        int result = calculatorService.calculate(input); // 예외가 발생하면 여기서 처리됨
        outputView.printResult(result);
    }
}
