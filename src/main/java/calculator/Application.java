package calculator;

import calculator.controller.CalcController;

public class Application {
    public static void main(String[] args) {
        CalcController calcController = new CalcController();
        calcController.run();
    }
}
