package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final Divider divider;
    private static final String DIVIDER_SPLIT_FORMAT = "%s|%s|%s";
    private static final String ESCAPE_CHARACTER = "\\";
    private static final List<String> META_CHARACTERS = new ArrayList<>(List.of(
            "*", "^", "$", ".", "+", "?", "|", "\\",
            "[", "]", "{", "}", "(", ")")
    );

    public NumberParser(Divider divider) {
        this.divider = divider;
    }

    public void parse(CalculatedValue calculatedValue) {
        List<Integer> numberValue = extractNumberValue(calculatedValue);
        calculatedValue.setNumberValueToken(numberValue);
    }


    private List<Integer> extractNumberValue(CalculatedValue calculatedValue) {
        List<Integer> result = new ArrayList<>();
        String dividers = formatDividerSplit();
        String[] values = calculatedValue.getValue().split(dividers);

        for (String value : values) {
            int numberValue = translateStringToInteger(value);
            validateNegativeNumberValue(numberValue);

            result.add(numberValue);
        }
        return result;
    }

    private int translateStringToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            validateCustomDividerMinusAndNumberValueNegative(value);
            validateContinuousDivider(value);
            throw new IllegalArgumentException("등록되지 않는 구분자가 존재합니다." + value);
        }
    }


    private String formatDividerSplit() {
        return String.format(DIVIDER_SPLIT_FORMAT,
                divider.getColon(),
                divider.getComma()
                , handleMetaCharacter(divider.getCustomDivider()));
    }

    private String handleMetaCharacter(String customDivider) {
        if (isMetaChar(customDivider)) {
            return addEscapeCharToMetaChar(customDivider);
        }
        return customDivider;
    }

    private String addEscapeCharToMetaChar(String metaCharacter) {
        return ESCAPE_CHARACTER + metaCharacter;
    }

    private boolean isMetaChar(String ch) {
        return META_CHARACTERS.contains(ch);
    }


    // 커스텀 구분자가 - 일때 --가 연속으로 사용될(//-\n1--2-3) 경우 음수 사용으로 분류
    private void validateCustomDividerMinusAndNumberValueNegative(String value) {
        if ("-".equals(divider.getCustomDivider()) && value.isEmpty()) {
            throw new IllegalArgumentException("음수는 계산이 불가능합니다.");
        }
    }

    private void validateNegativeNumberValue(int numberValue) {
        if (numberValue < 0) {
            throw new IllegalArgumentException("음수는 계산이 불가능합니다.");
        }
    }

    private void validateContinuousDivider(String value) {
        if ("".equals(value)) {
            throw new IllegalArgumentException("구분자가 연속으로 사용되었어요.");
        }
    }

}
