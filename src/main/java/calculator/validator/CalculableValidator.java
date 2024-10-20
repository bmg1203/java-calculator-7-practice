package calculator.validator;

import calculator.common.Delimiters;
import calculator.enums.ErrorMessage;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculableValidator {
    private static final String DELIMITER_REGEX_OR_OPERATOR = "|";
    private static final String VALID_PATTERN_TEMPLATE = "^[0-9%s]+$";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";


    private CalculableValidator() {
    }

    public static void validate(String input, Delimiters delimiters) {
        if (input.isEmpty()) {
            return;
        }

        String delimiterPattern = buildDelimiterPattern(delimiters);
        validateAllowedDelimiters(input, delimiterPattern);
        validateDelimiterPosition(input, delimiterPattern);
        validateNumberSize(input, delimiterPattern);
    }

    private static void validateAllowedDelimiters(String input, String delimiterPattern) {
        String validPattern = String.format(VALID_PATTERN_TEMPLATE, delimiterPattern);

        if (!Pattern.matches(validPattern, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CHAR_INCLUDED.getMessage());
        }
    }

    private static void validateDelimiterPosition(String input, String delimiterPattern) {
        String[] numbers = input.split(delimiterPattern);
        if (numbers.length < 2) {
            return;
        }

        StringBuilder positionPatternBuilder = new StringBuilder(NUMBER_PATTERN);
        for (int i = 0; i < numbers.length - 1; i++) {
            positionPatternBuilder
                    .append(OPEN_PARENTHESIS)
                    .append(delimiterPattern)
                    .append(CLOSE_PARENTHESIS)
                    .append(NUMBER_PATTERN);
        }

        String positionPattern = positionPatternBuilder.toString();
        if (!Pattern.matches(positionPattern, input)) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_MUST_BE_BETWEEN_NUMBERS.getMessage());
        }
    }

    private static void validateNumberSize(String input, String delimiterPattern) {
        String[] numbers = input.split(delimiterPattern);

        for (String number : numbers) {
            try {
                Long.parseLong(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_TOO_LARGE.getMessage());
            }
        }
    }

    private static String buildDelimiterPattern(Delimiters delimiters) {
        Set<String> allDelimiters = delimiters.getDelimiters();
        return allDelimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining(DELIMITER_REGEX_OR_OPERATOR));
    }
}
