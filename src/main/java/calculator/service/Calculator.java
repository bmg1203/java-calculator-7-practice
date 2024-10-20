package calculator.service;

import java.util.Arrays;

public class Calculator {

    public int sumNumber(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
