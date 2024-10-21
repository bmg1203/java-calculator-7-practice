package calculator.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void validateCustomDelimiter(String delimiter) {
        validateNullOrEmpty(delimiter);
        validateSingleCharacter(delimiter);
        validateCustomDelimiterNumber(delimiter);
    }

    public static void validateInput(String input, List<String> delimiters) {
        validateIncorrectDelimiterPosition(input, delimiters);
        validateConsecutiveDelimiters(input, delimiters);
        validateWhitespaceBetweenDelimiters(input, delimiters);
    }

    public static void validateMultipleCustomDelimiters(String input) {
        Pattern pattern = Pattern.compile("(//.+\\\\n){2,}");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException("여러 개의 커스텀 구분자 추출 문자열이 포함된 잘못된 입력값입니다.");
        }
    }

    public static void validateValidInteger(String value) {
        try {
            long parsedLong = Long.parseLong(value.trim());
            if (parsedLong > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("입력한 숫자가 정수 범위를 초과했습니다. 문제가 되는 입력값: [" + value + "]");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 유효한 정수가 아닙니다. 문제가 되는 입력값: [" + value + "]");
        }
    }

    public static void validatePositiveNumbers(List<Integer> numbers) {
        List<Integer> invalidNumbers = findNonPositiveNumbers(numbers);

        if (!invalidNumbers.isEmpty()) {
            throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다. 문제가 되는 입력값: " + invalidNumbers);
        }
    }


    private static List<Integer> findNonPositiveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number <= 0)
                .toList();
    }

    private static void validateIncorrectDelimiterPosition(String input, List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (input.startsWith(delimiter) || input.endsWith(delimiter)) {
                throw new IllegalArgumentException("구분자가 잘못된 위치에 있습니다. 입력값: [" + input + "]");
            }
        }
    }

    private static void validateConsecutiveDelimiters(String input, List<String> delimiters) {
        String delimiterPattern = String.join("", delimiters);

        Pattern pattern = Pattern.compile("[" + delimiterPattern + "]{2,}");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException("연속된 구분자가 포함된 잘못된 입력입니다. 입력값: [" + input + "]");
        }
    }

    private static void validateWhitespaceBetweenDelimiters(String input, List<String> delimiters) {
        String delimiterPattern = String.join("|", delimiters);
        String[] tokens = input.split(delimiterPattern);

        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                throw new IllegalArgumentException("구분자 사이에 공백이 포함된 잘못된 입력입니다. 입력값: [" + input + "]");
            }
        }
    }

    private static void validateNullOrEmpty(String delimiter) {
        if (delimiter == null || delimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }

    private static void validateSingleCharacter(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 구분자는 단일 문자여야 합니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }

    private static void validateCustomDelimiterNumber(String delimiter) {
        if (delimiter.matches("\\d")) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 숫자는 구분자로 사용할 수 없습니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }
}
