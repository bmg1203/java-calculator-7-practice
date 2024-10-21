package calculator;

import calculator.extract.ExtractRepository;
import calculator.extract.ExtractService;
import calculator.separator.SeparatorRepository;
import calculator.separator.SeparatorService;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        SeparatorRepository separatorRepository = new SeparatorRepository();
        ExtractRepository extractRepository = new ExtractRepository();

        ExtractService extractService = new ExtractService(extractRepository);
        SeparatorService separatorService = new SeparatorService(separatorRepository, extractRepository);

        Controller controller = new Controller(separatorService, extractService, calculator);

        controller.run();
    }
}
