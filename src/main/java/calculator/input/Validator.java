package calculator.input;

import static calculator.constants.DelimiterConstants.*;

public class Validator {
    private static final int DELIMITER_OFFSET = 2;

    public void check(String input) {
        checkString(input, null);
    }

    public void check(String input, String customDelimiter) {
        checkCustomDelimiter(customDelimiter);
        checkString(input, customDelimiter);
    }

    public boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START) && input.contains(CUSTOM_DELIMITER_END);
    }

    private void checkCustomDelimiter(String customDelimiter) { // 책임: 구분자가 올바른지 확인.
        if (customDelimiter.length() != 1 || Character.isDigit(customDelimiter.charAt(0))) { // 구분자는 숫자가 아닌 한 글자여야 함
            throw new IllegalArgumentException("Invalid custom delimiter: " + customDelimiter);
        }
    }

    private void checkString(String input, String customDelimiter) {
        int startIndex = 0;
        final int lastIndex = input.length() - 1;

        if (customDelimiter != null) {
            startIndex = input.indexOf(CUSTOM_DELIMITER_END) + DELIMITER_OFFSET; // 검사 시작 인덱스를 커스텀 지정자 선언 문구 이후로 설정
        }

        boolean isDelimiterAllowed = false;
        for (int i = startIndex; i <= lastIndex; i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                isDelimiterAllowed = true; // 다음에 구분자가 나와도 된다고 표시
                continue;
            }

            if (!isDelimiterAllowed) { // 문자 금지인데 구분자가 나왔다면
                throw new IllegalArgumentException("Invalid character at position " + i + ": " + currentChar);
            }

            if (isValidDelimiter(currentChar, customDelimiter) && i != lastIndex) { // 올바르게 구분자가 나왔다면
                isDelimiterAllowed = false; // 다음에는 구분자가 나오면 안된다고 표시
                continue;
            }

            throw new IllegalArgumentException("Invalid character at position " + i + ": " + currentChar);
        }
    }

    private boolean isValidDelimiter(char delimiter, String customDelimiter) {
        return delimiter == DELIMITER_COLON || delimiter == DELIMITER_COMMA ||
                (customDelimiter != null && delimiter == customDelimiter.charAt(0));
    }
}
