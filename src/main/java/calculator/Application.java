package calculator;

import calculator.mvc.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculator = CalculatorController.getInstance();

        calculator.calculateAdd();
    }
}
