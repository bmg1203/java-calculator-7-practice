package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.AppConfig.CUSTOM_DELIMITER_END;

/**
 * - 역할: 입력된 문자열을 구분자로 분류하여 숫자를 추출
 * - 책임: 문자열의 유효성을 검사하고, 올바른 형식이면 숫자를 분류
 */
public class Classifier {
    private final Delimiters delimiters;
    private final List<Integer> numbers;


    /**
     * 생성자: 입력 문자열과 구분자를 받아 유효성을 검사한 후 숫자를 분류
     * @param input 입력 문자열
     * @param delimiters Delimiters 객체 (구분자 처리)
     */
    public Classifier(String input, Delimiters delimiters) {
        this.delimiters = delimiters;
        isValid(input);
        this.numbers = classifyNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 입력 문자열의 전체 유효성을 검사
     * - 커스텀 구분자 여부에 따라 각각의 유효성 검사 실행
     * @param input 입력 문자열
     */
    private void isValid(String input) {
        if(delimiters.isCustomDelimiterPresent()){
            isCustomStringValid(input);
        }
        if(!delimiters.isCustomDelimiterPresent()){
            isStringValid(input);
        }
    }


    /**
     * 입력 문자열을 분류하여 숫자를 추출
     * - 구분자에 따라 다르게 처리
     * @param input 입력 문자열
     * @return 분류된 숫자 리스트
     */
    private List<Integer> classifyNumbers(String input) {
        if(input.isEmpty()){
            return List.of(0);
        }
        if(!delimiters.isCustomDelimiterPresent()) {
            return splitAndConvertInput(input, delimiters.getDefaultDelimiterForSplit());
        }
        return splitAndConvertInput(getExcludedString(input), delimiters.getCustomDelimiterForSplit());
    }

    /**
     * 문자열을 구분자로 나누고 숫자로 변환
     * - 이 함수의 기능이 너무 많지 않은지 한번 더 생각해봐야 함
     * @param input 입력 문자열
     * @param pattern 컴파일 된 Pattern 객체
     * @return 숫자로 변환된 리스트
     */
    private List<Integer> splitAndConvertInput(String input, Pattern pattern) {
        String[] numberStrings = pattern.split(input);
        List<Integer> numbersInteger = new ArrayList<>();
        for(String number : numberStrings) {
            numbersInteger.add(Integer.parseInt(number));
        }
        return numbersInteger;
    }


    /**
     * 커스텀 구분자를 제외한 문자열의 형식이 맞는지 확인
     * @param input 입력 문자열
     */
    private void isCustomStringValid(String input) {
        String excludedString = getExcludedString(input);
        Matcher matcher = delimiters.getCustomDelimiterPattern().matcher(excludedString);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("Invalid custom delimiter");
        }
    }

    /**
     * 커스텀 구분자를 제외한 문자열 가져오기
     * @param input 입력 문자열
     * @return 커스텀 구분자를 제외한 문자열
     */
    private String getExcludedString(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_END);
        return pattern.split(input)[1];
    }

    /**
     * 커스텀 구분자가 없는 경우 문자열 형식을 확인
     * - 기본 구분자로 나뉘어진 문자열이 올바른 형식인지 확인
     * @param input 입력 문자열
     */
    private void isStringValid(String input) {
        Matcher matcher = delimiters.getDefaultDelimiterPattern().matcher(input);
        if(!input.isEmpty() && !matcher.matches()) {
            throw new IllegalArgumentException("Invalid string");
        }
    }

}
