package calculator.exception;

import java.util.List;

public class Exceptions {

    public void validateCommaDelimiter(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException("[ERROR] 연속된 콤마(,,)는 사용할 수 없습니다.");
        }
    }

    public void validateColonDelimiter(String input) {
        if (input.contains("::")) {
            throw new IllegalArgumentException("[ERROR] 연속된 콜론(::)은 사용할 수 없습니다.");
        }
    }

    public void validateCustomDelimiter(String input, List<String> customDelimiter) {
        for (String s : customDelimiter) {
            String consecutiveDelimiter = s + s;
            if (input.contains(consecutiveDelimiter)) {
                throw new IllegalArgumentException("[ERROR] 연속된 커스텀 구분자는 사용할 수 없습니다.");
            }
        }
    }

    public void validateLeadingDelimiter(String input) {
        if ((input.charAt(0) == ',') || (input.charAt(0) == ':')) {
            throw new IllegalArgumentException("[ERROR] 문자열의 처음에 구분자가 올 수 없습니다.");
        }
    }

    public void validateLeadingCustomDelimiter(String input, List<String> customDelimiter) {
        for (String s : customDelimiter) {
            if (input.startsWith(s)) {
                throw new IllegalArgumentException("[ERROR] 문자열의 처음에 커스텀 구분자가 올 수 없습니다.");
            }
        }
    }

    public void validateNegativeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
            }
        }
    }

    public void validateCustomDelimiterSize(int count) {
        if(count > 3) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 3개까지 가능합니다.");
        }
    }

    public void isInvalidStringInList(String[] input) {
        for (String num : input) {
            try {
                Integer.parseInt(num);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 잘못된 문자열 형식입니다. (배열에 덧셈할 수 없는 문자 존재)");
            }
        }
    }

}
