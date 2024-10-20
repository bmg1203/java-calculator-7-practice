package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    private static final int EMPTY_INPUT_RETURN_VALUE = 0;

    private static final String CUSTOM_DELIMITER_START_SIGN = "//";
    private static final int CUSTOM_DELIMITER_START_SIGN_LENGTH = CUSTOM_DELIMITER_START_SIGN.length();

    private static final String CUSTOM_DELIMITER_END_SIGN = "\\n";
    private static final int CUSTOM_DELIMITER_END_SIGN_LENGTH = CUSTOM_DELIMITER_END_SIGN.length();

    public static void main(String[] args) {
        printInputMessage();

        String input = readLine();

        int result = getResult(input);

        printResultMessage(result);
    }

    private static int getResult(String input) {
        if (input.isEmpty()) {
            return EMPTY_INPUT_RETURN_VALUE;
        }
        /**
         * 1.1 기본 구분자만 입력된 경우
         */
        StringBuilder delimiterPart = new StringBuilder("[,:]");
        String numberPart = input;

        /**
         * 1.2 커스텀 구분자를 포함하여 입력된 경우
         */
        if (hasCustomDelimiter(input)) {
            int indexOfEndSign = input.indexOf(CUSTOM_DELIMITER_END_SIGN); // 개행문자가 아닌 '\n'라는 문자를 찾는다
            if (isEndSignMissing(indexOfEndSign)) {
                throw new IllegalArgumentException("커스텀 구분자 선언 후 '\\n'이 필요합니다.");
            }

            String[] customDelimiters = getCustomDelimiters(input, indexOfEndSign);

            validateCustomDelimiters(customDelimiters);

            appendCustomDelimiters(delimiterPart, customDelimiters);

            numberPart = getNumberPart(input, indexOfEndSign);
        }

        String[] eachNumbers = getEachNumbers(numberPart, delimiterPart);

        int[] parsedNumbers = parseNumbers(eachNumbers);

        validateNoNegativeNumbers(parsedNumbers);

        return add(parsedNumbers);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SIGN);
    }

    private static boolean isEndSignMissing(int indexOfEndSign) {
        return indexOfEndSign == -1;
    }

    private static String[] getCustomDelimiters(String input, int indexOfEndSign) {
        return input.substring(CUSTOM_DELIMITER_START_SIGN_LENGTH, indexOfEndSign)
                .split("");
    }

    private static void validateCustomDelimiters(String[] customDelimiters) {
        for (String delim : customDelimiters) {
            if (containsDigit(delim)) {
                throw new IllegalArgumentException("커스텀 구분자에 숫자가 포함될 수 없습니다: " + delim);
            }
        }
    }

    private static void appendCustomDelimiters(StringBuilder delimiterPart, String[] customDelimiters) {
        for (String delim : customDelimiters) {
            delim = delim.trim();

            if (!delim.isEmpty()) { // 빈 문자열로 파싱되지 않았다면 (3.3 구분자가 연속으로 입력된 경우)
                delimiterPart
                        .append("|")
                        .append(toRegex(delim));
            }
        }
    }

    private static String getNumberPart(String input, int indexOfEndSign) {
        return input.substring(indexOfEndSign + CUSTOM_DELIMITER_END_SIGN_LENGTH);
    }

    private static String[] getEachNumbers(String numberPart, StringBuilder delimiterPart) {
        return numberPart.split(delimiterPart.toString());
    }

    private static int[] parseNumbers(String[] eachNumbers) {
        return Arrays.stream(eachNumbers)
                .filter(Application::isNotEmpty)
                .map(String::trim)
                .mapToInt(Application::safeParseInt)
                .toArray();
    }

    private static void validateNoNegativeNumbers(int[] numbers) {
        if (Arrays.stream(numbers)
                .anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
    }

    private static int add(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }

    private static boolean containsDigit(String delim) {
        return delim.chars()
                .anyMatch(Character::isDigit);
    }

    private static String toRegex(String delim) {
        return Pattern.quote(delim);
    }

    private static boolean isNotEmpty(String n) {
        return !n.trim()
                .isEmpty();
    }

    private static int safeParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자부에 문자가 입력되었습니다. : " + number, e);
        }
    }

    private static void printInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private static void printResultMessage(int result) {
        System.out.println("결과 : " + result);
    }
}
