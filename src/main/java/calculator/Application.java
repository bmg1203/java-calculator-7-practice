package calculator;

import calculator.infra.controller.MainController;
import calculator.service.SeparateService;

public class Application {
    public static void main(String[] args) {
        MainController mainController = setUpController();
        mainController.runCalculator();
    }

    private static MainController setUpController() {
        SeparateService separateService = new SeparateService();
        return new MainController(separateService);
    }
}
