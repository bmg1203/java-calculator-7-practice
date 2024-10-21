package calculator.service.parse;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BigIntegerCalculatorInputParseService implements CalculatorInputParseService {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_START_STRING = "//";
    private static final String CUSTOM_DELIMITER_END_STRING = "\\n";
    private static final String CUSTOM_DELIMITER_PART_REGEX = "^//(.*?)\\\\n";

    @Override
    public List<BigInteger> parseSumInput(String input) {
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PART_REGEX);
        Matcher matcher = pattern.matcher(input);

        String numbersPart;
        if (matcher.find()) {
            String delimiterPart = matcher.group();
            numbersPart = input.substring(delimiterPart.length());
            String customDelimiter = delimiterPart.substring(
                    CUSTOM_DELIMITER_START_STRING.length(),
                    delimiterPart.length() - CUSTOM_DELIMITER_END_STRING.length()
            );

            delimiterRegex += "|" + "[" + Pattern.quote(customDelimiter) + "]";
        } else {
            numbersPart = input;
        }

        String[] numberStrings = numbersPart.split(delimiterRegex);

        return Arrays.stream(numberStrings)
                .map(this::parseSumNumber)
                .collect(Collectors.toList());
    }

    protected BigInteger parseSumNumber(String numberStr) {
        try {
            return new BigInteger(numberStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("변환할 수 없는 숫자입니다.: " + numberStr);
        }
    }
}
