package calculator;

import calculator.controller.AdderController;

public class Application {
    public static void main(String[] args) {
        AdderController adderController = new AdderController();
        adderController.run();
    }
}
