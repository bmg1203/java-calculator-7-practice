package calculator.model;

import calculator.common.CustomDelimiter;
import calculator.common.ExceptionMessage;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CustomInput extends UserInput {
    public CustomInput(String userInput) {
        super(userInput);
    }

    @Override
    protected void parseInputForCalculate(String userInput) {
        checkCustomDelimFormat(userInput);

        int delimiterStartIdx = userInput.indexOf(CustomDelimiter.START_FORMAT.getValue()) + 2;
        int delimiterEndIdx = userInput.indexOf(CustomDelimiter.END_FORMAT.getValue());

        extractCustomDelimiterAndAdd(userInput, delimiterStartIdx, delimiterEndIdx);

        String calculatePart = extractCalculatePart(userInput, delimiterEndIdx + 2);

        if (isCalculatePartEmpty(calculatePart)) return;

        String[] splitValues = splitCalculatePartByDelimiters(calculatePart);

        try {
            inputNumbers = Arrays.stream(splitValues)
                    .mapToLong(Long::parseLong)
                    .filter(this::checkNumIsPositive)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.CALCULATE_PART_IS_INVALID.getValue());
        }

        checkValidCalculatePart(calculatePart);
    }

    private boolean isCalculatePartEmpty(String calculatePart) {
        if (calculatePart.isEmpty()) {
            inputNumbers = new long[]{0};
            return true;
        }
        return false;
    }

    @Override
    protected String[] splitCalculatePartByDelimiters(String calculatePart) {
        try {
            String regex = String.join(REGEX_DELIMITER, delimiters.stream().map(Pattern::quote).toArray(String[]::new));
            return calculatePart.split(regex);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ExceptionMessage.CALCULATE_PART_IS_INVALID.getValue());
        }
    }

    /***
     * 커스텀 구분자포맷("//_\n)이 지켜졌는지 확인합니다.
     * @param userInput : 사용자의 입력
     */
    private void checkCustomDelimFormat(String userInput) {
        if (!userInput.contains(CustomDelimiter.END_FORMAT.getValue())) {
            throw new IllegalArgumentException(ExceptionMessage.CUSTOM_DELIMITER_FORMAT_NOT_MATCH.getValue());
        }
    }

    /***
     * 사용자의 입력으로부터 커스텀 구분자를 추출합니다.
     * @param userInput : 사용자의 입력
     * @param startIdx : 커스텀 구분자의 추출 시작 인덱스
     * @param endIdx : 커스텀 구분자의 추출 마지막 인덱스
     */
    private void extractCustomDelimiterAndAdd(String userInput, int startIdx, int endIdx) {
        String customDelimiter = userInput.substring(startIdx, endIdx);
        checkCustomDelimiterIncludeNumber(customDelimiter);

        delimiters.add(customDelimiter);
    }

    /***
     * 사용자의 입력으로부터 계산할 문자열을 추출합니다.
     * @param userInput : 사용자의 입력
     * @param startIdx : 추출 시작 인덱스
     * @return : 추출된 계산 문자열
     */
    private String extractCalculatePart(String userInput, int startIdx) {
        return userInput.substring(startIdx);
    }

    /***
     * 커스텀 구분자에 숫자가 사용되어있는지 검사합니다.
     * @param customDelimiter : 추출된 커스텀 구분자
     */
    private void checkCustomDelimiterIncludeNumber(String customDelimiter) {
        if (customDelimiter.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ExceptionMessage.CUSTOM_DELIMITER_NOT_INCLUDE_NUMBER.getValue());
        }
    }
}
