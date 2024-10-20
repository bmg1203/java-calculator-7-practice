package calculator.cal.numberadder.string;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public List<Integer> parseBySeparator(String inputString, String separator) {

        //구분자로 숫자 추출
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("식을 입력하지 않았습니다.");
        }

        //커스텀 구분자에 공백이 있는지 판단
        if (separator.contains(" ")) {
            inputString = inputString.trim();
        } else {
            inputString = inputString.replace(" ", "");
        }
        String[] numberStrings = inputString.split(separator);

        //문자열을 정수 형태로 변환
        List<Integer> numbers = convertNumberStringsToNumbers(numberStrings);

        return numbers;
    }

    private static List<Integer> convertNumberStringsToNumbers(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            Integer number = 0;

            //공백일 경우 0
            if (!(numberString.length() <= 0) && numberString.matches("\\d+")) {
                number = Integer.parseInt(numberString);
            } else if (numberString.matches("-\\d+")) {
                throw new IllegalArgumentException("양수끼리의 계산만 지원합니다.");
            } else if (!numberString.isEmpty()) {
                //숫자가 아닌 다른것이 들어온 경우 예외
                throw new IllegalArgumentException(numberString + "은(는) 숫자가 아닙니다.");
            }

            numbers.add(number);
        }
        return numbers;
    }

}