package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.service.CalculatorService;
import calculator.view.ErrorView;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final OutputView outputViewBean = new OutputView();
        final ErrorView errorViewBean = new ErrorView();
        final Calculator calculator = new Calculator();
        final CalculatorService calculatorService = new CalculatorService(calculator);

        final CalculatorController calculatorControllerBean = new CalculatorController(
                inputViewBean,
                outputViewBean,
                calculatorService
        );

        try {
            calculatorControllerBean.run();
        } catch (IllegalArgumentException e) {
            errorViewBean.errorPage(e.getMessage());
            throw e;
        }
    }
}
