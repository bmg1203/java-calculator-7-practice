package calculator.controller;

import java.util.regex.Pattern;

public class CustomDelimiterValidator {
    private static final Pattern CUSTOM_DELIMITER_REGEX_PATTERN = Pattern.compile("^[//.*\\n]");

    public boolean validate(String input) {
        // 커스텀 구분자를 지정하는가
        if (CUSTOM_DELIMITER_REGEX_PATTERN.matcher(input).find()) {
            customDelimiter(input);
            return true;
        }
        return false;
    }

    private void customDelimiter(String input) {
        // 커스텀 구분자 길이가 2 이상이거나 없으면 예외 throw
        if (input.indexOf("\n") > 3 || input.indexOf("\n") == 2) {
            throw new IllegalArgumentException();
        }

        char ch = input.charAt(2);
        // 커스텀 구분자가 문자가 아니면 예외 throw
        if (!Character.isLetter(ch) && !(ch >= 32 && ch <= 126 && !Character.isDigit(ch))) {
            throw new IllegalArgumentException();
        }
    }
}
