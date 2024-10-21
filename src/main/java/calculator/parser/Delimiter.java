package calculator.parser;

import calculator.global.DefaultDelimiter;
import calculator.global.DelimiterSyntaxIndex;

public class Delimiter {

    private static final Delimiter INSTANCE = new Delimiter();

    private Delimiter() {}

    public static Delimiter getInstance() {
        return INSTANCE;
    }

    public String extractDelimiter(String input) {
        if (validateStartsWith(input) && validateEndsWith(input)) {
            String rawDelimiter = String.valueOf(input.charAt(DelimiterSyntaxIndex.DELIMITER_INDEX.getKey()));

            return rawDelimiter.matches("[.\\^$|?*+(){}\\[\\]\\\\]") ? "\\" + rawDelimiter : rawDelimiter;
        }
        return "";
    }

    public String removeDelimiterSyntax(String input) {
        if (validateStartsWith(input) && validateEndsWith(input)) {
            return input.substring(DelimiterSyntaxIndex.DELIMITER_AFTER.getKey());
        }
        return input;
    }

    public boolean validateHasDefaultOrCustomDelimiter(String input, String customDelimiter) {
        String delimiters = DefaultDelimiter.COLON.getKey() + DefaultDelimiter.COMMA.getKey() + customDelimiter;
        String defaultSyntax = removeDelimiterSyntax(input);
        return defaultSyntax.matches("[0-9" + delimiters + "]*");
    }

    private boolean validateStartsWith(String input) {
        return input.startsWith("//");
    }

    private boolean validateEndsWith(String input) {
        return input.charAt(DelimiterSyntaxIndex.FIRST_END.getKey()) == '\\'
                && input.charAt(DelimiterSyntaxIndex.SECOND_END.getKey()) == 'n';
    }
}
