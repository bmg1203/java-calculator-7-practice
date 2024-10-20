package calculator.util;

import calculator.model.primitive.PositiveNumber;

public class StringAddCalculator {
    private static final int ZERO_VALUE = 0;
    private static final String BLANK = " ";

    public static int splitAndSum(String input) {
        if (validateNull(input)) {
            return ZERO_VALUE;
        }
        validateContainBlank(input);

        return calculateSum(splitByInput(input));
    }

    private static boolean validateNull(String input) {
        return isNull(input) || isEmpty(input);
    }

    private static void validateContainBlank(String input) {
        if (isContainBlank(input)) {
            throw new IllegalArgumentException("공백을 포함할 수 없습니다.");
        }
    }

    private static int calculateSum(String[] splitInput) {
        int sum = ZERO_VALUE;
        for (String splitNumber : splitInput) {
            PositiveNumber positiveNumber = PositiveNumber.create(toInt(splitNumber));
            sum = positiveNumber.sumNumber(sum);
        }
        return sum;
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isContainBlank(String input) {
        return input.contains(BLANK);
    }

    private static String[] splitByInput(String input) {
        return Separator.splitByDelimiter(input);
    }

    private static int toInt(String splitNumber) {
        return validateParseNumber(splitNumber);
    }

    private static int validateParseNumber(String splitNumber) {
        try {
            return Integer.parseInt(splitNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("구분자가 잘못 되었습니다. 커스텀 구분자, 기본 구분자를 확인 후, 다시 입력하세요");
        }
    }
}
