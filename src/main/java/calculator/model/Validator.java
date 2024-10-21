package calculator.model;

import java.util.regex.Pattern;

public class Validator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public int validateInput(String input) {
        if (input == null||input.isEmpty()) {
            return 0;
        }
        if (!startsWithValidCharacter(input)) {
            throw new IllegalArgumentException();
        }

        return -1;
    }

    public boolean startsWithValidCharacter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START) || Character.isDigit(input.charAt(0));
    }

    public String getDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_END);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            String customDelimiters = input.substring(2, delimiterEndIndex);
            if (customDelimiters.isEmpty() || customDelimiters.length() > 1 || Character.isDigit(customDelimiters.charAt(0))) {
                throw new IllegalArgumentException();
            }
            return Pattern.quote(customDelimiters);
        }
        return DEFAULT_DELIMITERS;
    }

    public String getNumbersPart(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int numbersStartIndex = input.indexOf(CUSTOM_DELIMITER_END);
            return input.substring(numbersStartIndex + 2);
        }
        return input;
    }

    public String[] splitNumbers(String numbersPart, String delimiter) {
        return numbersPart.split(delimiter);
    }


    public void validateLastNumber(String numbersPart) {
        char lastChar = numbersPart.charAt(numbersPart.length() - 1);

        if (!Character.isDigit(lastChar)) {
            throw new IllegalArgumentException();
        }
    }
}
