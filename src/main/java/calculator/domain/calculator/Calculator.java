package calculator.domain.calculator;

import java.util.Arrays;

public class Calculator {

    public int sumAll(Integer[] parsedValues) {
        return Arrays.stream(parsedValues).mapToInt(Integer::intValue).sum();
    }
}
