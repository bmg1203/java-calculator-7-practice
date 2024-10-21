package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculateService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController controller = new CalculatorController(new InputView(), new CalculateService(), new OutputView());

        controller.run();
    }
}
