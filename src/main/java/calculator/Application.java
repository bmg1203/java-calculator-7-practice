package calculator;

import calculator.domain.UserRequest;
import calculator.io.CustomReader;
import calculator.io.CustomWriter;
import calculator.service.Calculator;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CustomWriter.printInitMessage();
        UserRequest userRequest = new UserRequest(CustomReader.readLine());
        Calculator calculator = new Calculator();
        CustomWriter.printResultMessage(calculator.sum(userRequest.extractNumbers()));
    }
}
