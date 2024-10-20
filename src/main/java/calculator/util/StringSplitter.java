package calculator.util;

import static calculator.config.SystemConstantMessages.UTILITY_CLASS_MESSAGE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_SPLITTER = "[,:]";

    private StringSplitter() {
        throw new IllegalStateException(UTILITY_CLASS_MESSAGE);
    }

    public static String[] splitUserInput(String userInput) {
        Pattern pattern = Pattern.compile("//(.*?)\\n(.*)");
        Matcher matcher = pattern.matcher(userInput);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String content = matcher.group(2);

            return content.split(Pattern.quote(customDelimiter));
        } else {
            return userInput.split(DEFAULT_SPLITTER);
        }
    }
}
