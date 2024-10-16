package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run() {
        OutputView.printInputStringMessage();
        InputView.readInputString();
    }
}
