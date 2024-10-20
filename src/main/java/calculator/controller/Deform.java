package calculator.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 입력값을 변형하는 Deform 클래스. 입력값을 변형하는 메서드인 slice, extractNumbers를 포함한다.
 */

public class Deform {
    /**
     * 입력받는 문자열을 start부터 end까지 자른고 반환
     */
    public static String slice(String input, int start, int end) {
        return input.substring(start, end);
    }

    /**
     * 입력받는 문자열 내부 숫자들을 Integer 리스트에 담아서 반환. 입력 받는 문자열은 반드시 숫자와 구분자로만 이루어져야 함.
     */
    public List<Integer> extractNumbers(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();

        List<Character> inputCharArr = strToCharArr(input);
        for (int i = 0; i < inputCharArr.size(); i++) {
            numbers.add(Character.getNumericValue(inputCharArr.get(i)));
        }

        return numbers;
    }

    List<Character> strToCharArr(String input) {
        List<Character> charArr = new ArrayList<>();
        for (int i = 0; i < input.length(); i += 2) {
            charArr.add(input.charAt(i));
        }
        return charArr;
    }
}
