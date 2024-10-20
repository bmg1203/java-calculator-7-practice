package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;

public class CalculatorController {
    static Calculator calculator = new Calculator();

    public static void add() {
        String input = InputView.inputString();
        if (input.trim().isEmpty()) {
            calculator.setResult(0);
            OutputView.printResult(calculator);
            return;
        }
        String[] nums = StringSplitter.splitter(input);
        int[] numbers = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i : numbers) {
            isPositive(i);
            sum += i;
        }
        calculator.setResult(sum);
        OutputView.printResult(calculator);
    }

    private static void isPositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다. 입력된 값 : " + num);
        }
    }
}
