package calculator.domain;

import java.util.List;

public class NumberValidator {
    private static final String ERROR_MESSAGE_FOR_NEGATIVE_NUMBER = "음수를 입력하셨습니다. 프로그램을 종료합니다.";
    private static final String ERROR_MESSAGE_FOR_ZERO = "0을 입력하셨습니다. 프로그램을 종료합니다.";

    public static void validateNumber(List<Integer> numbers) {
        if (hasNegativeNumber(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NEGATIVE_NUMBER);
        }
        if (hasZero(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_ZERO);
        }
    }

    private static boolean hasNegativeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 0);
    }

    private static boolean hasZero(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number == 0);
    }
}
