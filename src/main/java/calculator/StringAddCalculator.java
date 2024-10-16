package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    private static final int CUSTOM_DELIMITER_ORDER = 1;
    private static final int ARITHMETIC_EXPRESSION_ORDER = 2;
    // ex) 커스텀 구분자를 ;로 정했을 때, //;\n1;2;3
    private static final String CUSTOM_REGEX = "//(.)\\\\n(.*)";

    public int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        String[] delimiterAndNumbers = extractCustomDelimiterAndNumbers(input);
        String delimiters = delimiterAndNumbers[0];
        String numbersString = delimiterAndNumbers[1];
        List<Integer> numbers = splitNumbers(delimiters, numbersString);
        validateNumbers(numbers);
        return sum(numbers);
    }

    private String[] extractCustomDelimiterAndNumbers(String input) {
        String delimiters = DEFAULT_DELIMITER;
        String numbersString = input;

        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_ORDER);
            numbersString = matcher.group(ARITHMETIC_EXPRESSION_ORDER);
            // TODO: Pattern.quote() 로직을 검증하라
            delimiters += "|" + Pattern.quote(customDelimiter);
        }
        return new String[]{delimiters, numbersString};
    }

    private List<Integer> splitNumbers(String delimiters, String numbersString) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = numbersString.split(delimiters);
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(
                        String.format("(%s)는 음수입니다. 입력하는 숫자들은 반드시 양수 혹은 0이어야 합니다.", number)
                );
            }
        }
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
