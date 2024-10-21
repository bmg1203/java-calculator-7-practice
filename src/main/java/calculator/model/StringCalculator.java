package calculator.model;

import calculator.error.ErrorCode;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = "[,|:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEW_LINE_LITERAL = "\\n"; // 문자 그대로 "\n"
    private static final int EMPTY_RESULT = 0;
    private static final int NON_NEGATIVE_THRESHOLD = 0; // 음수 판별 기준
    private static final int INVALID_INDEX = -1; // 구분자가 없는 경우

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_RESULT;
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return sum(parseNumbersWithCustomDelimiter(input));
        }

        return sum(parseNumbers(input));
    }

    private int[] parseNumbers(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITERS);
        return convertToNumbers(tokens);
    }

    private int[] parseNumbersWithCustomDelimiter(String input) {
        // "//;\n1;2;3" 형식을 "\\n"을 기준으로 두 부분으로 나누기
        int delimiterIndex = input.indexOf(NEW_LINE_LITERAL);
        if (delimiterIndex == INVALID_INDEX) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DELIMITER_FORMAT.getMessage(input));
        }

        // 커스텀 구분자는 "//" 이후부터 "\\n" 이전까지의 문자열
        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
        String numbersPart = input.substring(delimiterIndex + NEW_LINE_LITERAL.length());

        // 커스텀 구분자를 사용하여 숫자 부분을 분리
        String[] tokens = numbersPart.split(Pattern.quote(customDelimiter));
        return convertToNumbers(tokens);
    }

    private int[] convertToNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(this::toPositiveNumber)
                .toArray();
    }

    private int toPositiveNumber(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < NON_NEGATIVE_THRESHOLD) {
                throw new IllegalArgumentException(ErrorCode.NEGATIVE_NUMBER.getMessage(value));
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_FORMAT.getMessage(value));
        }
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
