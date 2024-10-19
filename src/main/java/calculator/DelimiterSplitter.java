package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterSplitter {
    private String str;
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public DelimiterSplitter(String str) {
        this.str = str;
    }

    public String[] split() {
        if (Pattern.matches(CUSTOM_DELIMITER, str)) {
            return customDelimiterSplit();
        }
        return basicDelimiterSplit();
    }

    private String[] basicDelimiterSplit() {
        return str.split(BASIC_DELIMITER);
    }

    private String[] customDelimiterSplit() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return new String[0];
    }
}
