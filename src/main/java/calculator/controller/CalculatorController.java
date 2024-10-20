package calculator.controller;

import calculator.service.InputValidator;
import calculator.util.DelimiterExtractor;
import calculator.util.NumberExtractor;
import calculator.service.SumCalculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculatorController {

    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    private final InputValidator inputValidator;
    private final SumCalculator sumCalculator;

    public CalculatorController() {
        this.inputValidator = new InputValidator();
        this.sumCalculator = new SumCalculator();
    }

    public void run() {
        String input = getInput();

        inputValidator.validate(input);
        List<String> delimiters = DelimiterExtractor.extract(input);
        List<Integer> numbers = NumberExtractor.extract(input, delimiters);
        int result = sumCalculator.calculate(numbers);

        getResult(result);
    }

    private String getInput() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    private void getResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

}
