package calculator.model;

import static calculator.enumStatus.ExceptionMessage.INVALID_INPUT_CHAR;
import static calculator.enumStatus.ExceptionMessage.INVALID_NUM_RANGE;

import java.math.BigInteger;
import java.util.Objects;

public class Formatter {

    private static final BigInteger MAX_INT = BigInteger.valueOf(Integer.MAX_VALUE);

    public static int[] formatInput(String input, String delimiters) {
        input = removeCustomSetting(input, delimiters);

        validateInvalidChar(input, delimiters);
        String[] splitResult = input.split("[" + delimiters + "]");

        return generateFormatResult(splitResult);
    }

    private static String removeCustomSetting(String input, String delimiters) {
        if (delimiters.length() > 2) {
            input = input.substring(5);
        }
        return input;
    }

    private static void validateInvalidChar(String input, String delimiters) {
        if (!input.matches("[0-9" + delimiters + "]*")) {
            throw new IllegalArgumentException(INVALID_INPUT_CHAR.toString());
        }
    }

    private static int[] generateFormatResult(String[] splitResult) {
        int[] formatResult = new int[splitResult.length];
        for (int i = 0; i < formatResult.length; i++) {
            validateMaxNum(splitResult[i]);
            formatResult[i] = Integer.parseInt(!Objects.equals(splitResult[i], "") ? splitResult[i] : "0");
        }

        return formatResult;
    }

    private static void validateMaxNum(String s) {
        if (!s.isEmpty() && new BigInteger(s).compareTo(MAX_INT) > 0) {
            throw new IllegalArgumentException(INVALID_NUM_RANGE.toString());
        }
    }
}