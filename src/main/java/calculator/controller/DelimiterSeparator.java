package calculator.controller;

import calculator.model.Delimiter;

public class DelimiterSeparator {
    public static int detectCustomDelimiter(String userInput) {
        int index = 0;
        if (!NumberChecker.isNumber(userInput.substring(0, 1))) {
            index = registerCustomDelimiter(userInput);
        }
        return index;
    }

    public static int registerCustomDelimiter(String userInput) {
        if (!userInput.startsWith("//")) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        int index = 2;
        if (userInput.substring(index).length() < 3) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        Delimiter.updateDelimiter(userInput.charAt(index));
        if (!userInput.startsWith("\\n", index + 1)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return index + 3;
    }

    public static void validateDelimiter(char ch) {
        if (!Delimiter.isDelimiter(ch)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }
}
