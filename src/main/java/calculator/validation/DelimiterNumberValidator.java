package calculator.validation;

import calculator.exception.ErrorMessage;
import calculator.util.IntegerUtils;

import java.util.Arrays;

public class DelimiterNumberValidator {

    public int[] isValidNumber(String[] number) {
        return Arrays.stream(number)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    private int parseNumber(String number) {
        if (IntegerUtils.isNumeric(number)) {
            int parseInt = Integer.parseInt(number);
            validatePositiveNumber(parseInt);
            return parseInt;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
    }

    private void validatePositiveNumber(int parseInt) {
        if (parseInt < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

}