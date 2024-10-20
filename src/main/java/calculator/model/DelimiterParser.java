package calculator.model;

import calculator.exception.ExceptionMessages;
import java.util.regex.Pattern;

public class DelimiterParser {

    public String parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException(ExceptionMessages.CUSTOM_DELIMITER_ERROR);
                }
                return Pattern.quote(customDelimiter);
            } else {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DELIMITER_FORMAT);
            }
        }
        return null;
    }
}