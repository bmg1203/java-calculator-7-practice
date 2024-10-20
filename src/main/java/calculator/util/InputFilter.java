package calculator.util;

import calculator.exception.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilter {

    private static final String CUSTOM_REGEX = "^//.*\\\\n.*$";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);

    private static final String DEFAULT_REGEX = "^[,:\\d]*$";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(DEFAULT_REGEX);

    public static void doOutWrong(String input) {
        if (doNotMatchWithAnyPatterns(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_REGEX.getMessage());
        }
    }

    private static boolean doNotMatchWithAnyPatterns(String input) {
        Matcher defaultMatcher = DEFAULT_PATTERN.matcher(input);
        Matcher customMatcher = CUSTOM_PATTERN.matcher(input);

        return !defaultMatcher.matches() && !customMatcher.matches();
    }
}