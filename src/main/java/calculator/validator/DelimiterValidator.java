package calculator.validator;

import calculator.exception.delimiter.DelimiterException;

import static calculator.exception.delimiter.DelimiterExceptionMessage.*;

public class DelimiterValidator {

    private static final int NON_EXIST = -1;
    private static final String CUSTOM_DELIMITER_PREFIX_FORMAT = "//";

    public static void validateStartIndexExists(String stringWithDelimiter) {
        if (!stringWithDelimiter.startsWith(CUSTOM_DELIMITER_PREFIX_FORMAT)) {
            throw new DelimiterException(WRONG_CUSTOM_DELIMITER_FORMAT);
        }
    }

    public static void validateEndIndexExists(int endIndex) {
        if (endIndex == NON_EXIST) {
            throw new DelimiterException(WRONG_CUSTOM_DELIMITER_FORMAT);
        }
    }

    public static void validateEmptyCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new DelimiterException(EMPTY_CUSTOM_DELIMITER);
        }
    }

    public static void validateNumberCustomDelimiter(String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
            throw new DelimiterException(NUMBER_CUSTOM_DELIMITER);
        } catch (NumberFormatException ignored) {
        }
    }
}
