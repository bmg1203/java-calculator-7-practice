package calculator;

import calculator.controller.CalculatorController;

public class Application {
    private static final CalculatorController calculatorController = CalculatorController.getInstance();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        calculatorController.calcFromString();
    }
}
