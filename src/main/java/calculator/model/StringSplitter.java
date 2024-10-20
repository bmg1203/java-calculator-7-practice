package calculator.model;

import static calculator.validate.Validator.handleConversionError;
import static calculator.validate.Validator.validateInputStringAndDelimiters;
import static calculator.validate.Validator.validateNegativeNumber;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    private static final String OR_OPERATOR = "|";
    private static final String REGEX_QUOTE_START = "\\Q";
    private static final String REGEX_QUOTE_END = "\\E";
    private static final String MINUS = "-";
    private static final String ESCAPED_HYPHEN = "\\-";

    public List<Integer> splitAndConvertToIntegers(String inputString, List<String> delimiters,
                                                   boolean allowNegativeNumbers) {
        validateInputStringAndDelimiters(inputString, delimiters);

        String[] splitInputString = splitInputStringByDelimiters(inputString, delimiters);

        return convertStringArrayToIntegerList(splitInputString, allowNegativeNumbers);
    }

    private String[] splitInputStringByDelimiters(String inputString, List<String> delimiters) {
        String regex = createRegexFromDelimiters(delimiters);

        return inputString.split(regex);
    }

    private String createRegexFromDelimiters(List<String> delimiters) {
        StringBuilder regexBuilder = new StringBuilder();

        for (String delimiter : delimiters) {
            appendOrOperatorWhenNeeded(regexBuilder);
            appendEscapedDelimiter(regexBuilder, delimiter);
        }

        return regexBuilder.toString();
    }

    private void appendEscapedDelimiter(StringBuilder regexBuilder, String delimiter) {
        if (delimiter.equals(MINUS)) {
            regexBuilder.append(ESCAPED_HYPHEN);
        }

        regexBuilder.append(makeDelimiterRegexWithEscape(delimiter));
    }

    private void appendOrOperatorWhenNeeded(StringBuilder regexBuilder) {
        if (!regexBuilder.isEmpty()) {
            regexBuilder.append(OR_OPERATOR);
        }
    }

    private String makeDelimiterRegexWithEscape(String delimiter) {
        return REGEX_QUOTE_START + delimiter + REGEX_QUOTE_END;
    }

    private List<Integer> convertStringArrayToIntegerList(String[] splitInputString, boolean allowNegativeNumbers) {
        List<Integer> convertedIntegerList = new ArrayList<>();

        for (String inputStringPart : splitInputString) {
            if (!inputStringPart.trim().isEmpty()) {
                convertedIntegerList.add(convertToInteger(inputStringPart, allowNegativeNumbers));
            }
        }

        return convertedIntegerList;
    }

    private Integer convertToInteger(String inputStringPart, boolean allowNegativeNumbers) {
        try {
            int number = Integer.parseInt(inputStringPart.trim());

            validateNegativeNumber(number, allowNegativeNumbers, inputStringPart);

            return number;
        } catch (NumberFormatException e) {
            handleConversionError(inputStringPart);

            return null;
        }
    }
}
