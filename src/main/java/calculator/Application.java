package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static calculator.ErrorMessages.*;

public class Application {
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String COMMA_OR_SEMICOLON = COMMA + "|" + SEMICOLON;
    private static final String EMPTY = "";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\\\n";

    public static void main(String[] args) {
        String input = Console.readLine();
        BigInteger result = add(input);
        System.out.println("결과 : " + result);
    }

    private static BigInteger add(String input) {
        boolean isNotContainingDelimiter = !input.contains(COMMA) && !input.contains(SEMICOLON);

        if (input.isEmpty()) {
            return BigInteger.valueOf(0);
        }

        if (input.matches(".*//(.+)\\\\n.*")) {
            List<String> customDelimiterInputs = Arrays.stream(input.split(CUSTOM_DELIMITER_END))
                    .filter(letter -> !letter.isBlank())
                    .toList();

            String expression = customDelimiterInputs.getLast();
            if (expression.contains(CUSTOM_DELIMITER_START)) {
                throw new IllegalArgumentException(ERROR_NO_EXPRESSION_CUSTOM_DELIMITER);
            }

            if (customDelimiterInputs.size() > 2) {
                throw new IllegalArgumentException(ERROR_CUSTOM_DELIMITER_OVER_TWO);
            }

            String firstToTwoLetter = customDelimiterInputs.getFirst().substring(0, 2);
            if (!firstToTwoLetter.equals(CUSTOM_DELIMITER_START)) {
                throw new IllegalArgumentException(ERROR_CUSTOM_DELIMITER_NOT_START_WITH_FORMAT);
            }

            String customDelimiter = customDelimiterInputs.getFirst().substring(2);
            try {
                new BigInteger(customDelimiter);
            } catch (NumberFormatException e) {
                List<BigInteger> operands;
                try {
                    operands = Arrays.stream(expression.split(Pattern.quote(customDelimiter)))
                            .map(String::trim)
                            .map(BigInteger::new)
                            .toList();
                } catch (NumberFormatException i) {
                    throw new IllegalArgumentException(ERROR_CUSTOM_DELIMITER_OPERANDS_CONTAIN_OTHER_CHAR);
                }

                validatePositive(operands, ERROR_CUSTOM_DELIMITER_CONTAIN_ZERO, ERROR_CUSTOM_DELIMITER_CONTAIN_MINUS);

                return operands.stream()
                        .reduce(BigInteger.valueOf(0), BigInteger::add);
            }
            throw new IllegalArgumentException(ERROR_CUSTOM_DELIMITER_CONTAIN_NUMBER);
        }

        if (isNotContainingDelimiter) {
            throw new IllegalArgumentException(ERROR_NOT_CONTAIN_DELIMITER);
        }

        String[] delimiters = {COMMA, SEMICOLON, COMMA_OR_SEMICOLON};
        for (String delimiter : delimiters) {
            validateOnlyDelimiter(input, delimiter);
        }

        List<String> stringInputs = Arrays.stream(input.split(COMMA_OR_SEMICOLON))
                .filter(letter -> !letter.equals(EMPTY))
                .map(String::trim)
                .toList();

        List<BigInteger> bigIntegerParsedInputs;
        try {
            bigIntegerParsedInputs = stringInputs.stream()
                    .map(BigInteger::new)
                    .toList();

        } catch (NumberFormatException e) {
            for (String stringInput : stringInputs) {
                boolean isNumeric = stringInput.matches("\\d+");
                if (!isNumeric) {
                    throw new IllegalArgumentException(ERROR_BASIC_DELIMITER_OPERAND_CONTAIN_OTHER_CHAR);
                }
            }

            throw new IllegalArgumentException(ERROR_BASIC_DELIMITER_PARSING_PROBLEM);
        }

        validatePositive(bigIntegerParsedInputs, ERROR_BASIC_DELIMITER_CONTAIN_ZERO, ERROR_BASIC_DELIMITER_CONTAIN_MINUS);

        return bigIntegerParsedInputs.stream()
                .reduce(BigInteger.valueOf(0), BigInteger::add);
    }

    private static void validatePositive(List<BigInteger> operands, String errorCustomDelimiterContainZero, String errorCustomDelimiterContainMinus) {
        for (BigInteger inputNumber : operands) {
            if (inputNumber.compareTo(BigInteger.ZERO) == 0) {
                throw new IllegalArgumentException(errorCustomDelimiterContainZero);
            }

            if (inputNumber.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException(errorCustomDelimiterContainMinus);
            }
        }
    }

    private static void validateOnlyDelimiter(String input, String delimiter) {
        List<String> inputs = Arrays.stream(input.split(delimiter)).toList();
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException(delimiter + ERROR_BASIC_DELIMITER_ONLY_DELIMITER_SUPPORT);
        }
    }

}
