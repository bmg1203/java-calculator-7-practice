package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Decoder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Decoder decoder = new Decoder(inputView.readInput());
        Calculator calculator = new Calculator(decoder);
        outputView.printResult(calculator);
    }
}
