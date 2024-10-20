package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String CUSTOM_PATTERN = "^//(.*)\\\\n(.*)";
    private static final String DEFAULT_PATTERN = "[,:]";
    private static final String DIGITS_PATTERN = "\\d+";
    private static final Pattern COMPILE_PATTERN = Pattern.compile(CUSTOM_PATTERN);
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int VALUES_GROUP_INDEX = 2;

    public static String[] splitByDelimiter(String input) {
        Matcher matcherPattern = compileMatcher(input);

        if (isFindMatcher(matcherPattern)) {
            String delimiter = getCustomDelimiter(matcherPattern);
            return splitInputByCustomDelimiter(matcherPattern, delimiter);
        }

        return splitInputByDefaultDelimiter(input);
    }

    private static Matcher compileMatcher(String input) {
        return COMPILE_PATTERN.matcher(input);
    }

    private static boolean isFindMatcher(Matcher matcherPattern) {
        return matcherPattern.find();
    }

    private static String getCustomDelimiter(Matcher matcherPattern) {
        return matcherPattern.group(CUSTOM_DELIMITER_GROUP_INDEX);
    }

    private static String[] splitInputByCustomDelimiter(Matcher matcherPattern, String delimiter) {
        return getDelimitedValues(matcherPattern).split(delimiter);
    }

    private static String getDelimitedValues(Matcher matcherPattern) {
        return matcherPattern.group(VALUES_GROUP_INDEX);
    }

    private static String[] splitInputByDefaultDelimiter(String input) {
        if (isDigitsOnly(input)) {
            return new String[]{input};
        }

        return input.split(DEFAULT_PATTERN);
    }

    private static boolean isDigitsOnly(String input) {
        return input.matches(DIGITS_PATTERN);
    }
}
