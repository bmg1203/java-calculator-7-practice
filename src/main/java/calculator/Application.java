package calculator;


import calculator.controller.CalculatorController;
import calculator.controller.ViewController;
import calculator.service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController calculatorController = new CalculatorController(calculatorService);
        ViewController viewController = new ViewController(calculatorController);

        viewController.work();
    }
}
