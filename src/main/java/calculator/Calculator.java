package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String input;
    private String separatorRegex;

    Calculator(String input) {
        this.input = input.trim();
        this.separatorRegex = Regex.DEFAULT_SEPARATOR_REGEX.getPattern();
    }

    private void updateInput(String input) {
        this.input = input;
    }

    private void updateSeparatorRegex(String additionalSeparator) {
        if (additionalSeparator.isEmpty()) {
            return;
        }

        if (isSpecialCharacter(additionalSeparator)) {
            this.separatorRegex = this.separatorRegex
                    + Delimiter.OR.getValue()
                    + Delimiter.BRACKET_OPEN.getValue()
                    + additionalSeparator
                    + Delimiter.BRACKET_CLOSE.getValue();
        } else {
            this.separatorRegex = this.separatorRegex
                    + Delimiter.OR.getValue()
                    + additionalSeparator;
        }
    }

    public Integer caculate() {
        List<String> strs = extract();

        List<Integer> numbers = stringToInteger(strs);

        Integer result = sum(numbers);

        return result;
    }

    private List<String> extract() {
        List<String> strings = new ArrayList<>();

        if (input.isEmpty()) {
            return strings;
        }

        if (input.startsWith(Delimiter.CUSTOM_SEPARATOR_START.getValue())) {
            if (input.contains(Delimiter.CUSTOM_SEPARATOR_END.getValue())) {
                String customDelim = input.substring(
                        2,
                        input.indexOf(Delimiter.CUSTOM_SEPARATOR_END.getValue())
                );
                updateSeparatorRegex(customDelim);

                int startIdx = input.indexOf(Delimiter.CUSTOM_SEPARATOR_END.getValue())
                        + Delimiter.CUSTOM_SEPARATOR_END.getValue().length();
                updateInput(input.substring(startIdx));
            } else {
                throw new IllegalArgumentException("\n지정 구분자는 //와 \\n 사이에 입력해주세요");
            }
        }

        strings = Arrays.stream(input.split(separatorRegex))
                .toList();

        return strings;
    }

    private List<Integer> stringToInteger(List<String> strs) {
        List<Integer> numbers = strs.stream()
                .filter(s -> !s.isEmpty() && !s.isBlank())
                .map(s -> {
                    if (!s.matches(Regex.NUMBER_REGEX.getPattern())) {
                        throw new IllegalArgumentException(s + " 는 허용되지 않는 문자입니다");
                    }
                    return Integer.parseInt(s);
                })
                .toList();

        return numbers;
    }

    private Integer sum(List<Integer> numbers) {
        Integer result = 0;

        result = numbers.stream()
                .reduce(result, Integer::sum);

        return result;
    }

    private boolean isSpecialCharacter(String str) {
        if (str.matches(Regex.SPECIAL_CHARACTER_REGEX.getPattern())) {
            return true;
        } else {
            return false;
        }
    }
}
