package calculator.domain;

public class InputValidator {

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }


    public static void validateOnlyDigits(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Input must be a string consisting of a delimiter and a positive number.");
        }
    }


    public static void validateExtractedNumbers(String[] numbers) {
        for (String number : numbers) {
            validateOnlyDigits(number);
            validatePositiveNumber(Integer.parseInt(number));
        }
    }

    public static void validateCustomDelimiter(String customDelimiter) {
        if (isOnlyDigits(customDelimiter)) {
            throw new IllegalArgumentException("Custom delimiter must contain a string");
        }
    }

    public static boolean isOnlyDigits(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
