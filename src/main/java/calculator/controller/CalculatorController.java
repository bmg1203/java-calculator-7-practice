package calculator.controller;

import calculator.utils.Parse;
import calculator.utils.Split;
import calculator.validator.NumberValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private static final int MIN_NUMBER = 0;
    private String input;
    private int sum = 0;
    private List<String> separators = new ArrayList<>();
    private List<String> numberStr;
    private List<Integer> numbers;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        start();
        if (input.isEmpty()) {
            printResult(0);
            return;
        }
        parseString();
        validateNumbers();
        calculator();
        printResult(sum);
    }

    private void start() {
        input = inputView.inputString();
        Console.close();

        if (input.contains("//") && input.contains("\\\n")) {
            customSeparator(input);
        }
        //기본 구분자 추가
        separators.add(",");
        separators.add(":");
    }

    private void customSeparator(String input) {
        List<String> splits = Split.customSplit(input);
        separators.addAll(splits);
    }

    private void parseString() {
        input = Split.removeCustom(input);
        numberStr = Parse.parseSeparators(separators, input);
    }

    private void validateNumbers() {
        numbers = NumberValidator.validateNumbers(numberStr);
    }

    private void calculator () {
        for (int num : numbers) {
            if (num < MIN_NUMBER) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }
    }

    private void printResult(int sum) {
        outputView.outputPrint(sum);
    }
}
