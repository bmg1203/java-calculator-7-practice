package calculator;

import java.util.HashSet;

public class DelimiterManager {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    static final HashSet<String> defaultDelimiters = new HashSet<>();
    static HashSet<String> customDelimiters = new HashSet<>();

    static {
        defaultDelimiters.add(COMMA);
        defaultDelimiters.add(COLON);
    }

    public void registerCustomDelimiter(String delimiter) {
        customDelimiters.add(delimiter);
    }

    public boolean isValidDelimiter(String delimiter) {
        if (defaultDelimiters.contains(delimiter) || customDelimiters.contains(delimiter)) {
            return true;
        }
        return false;
    }
}
