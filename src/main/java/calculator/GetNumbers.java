package calculator;

import java.util.ArrayList;
import java.util.List;

// 구분자 기준으로 숫자를 추출하는 GetNumbers 클래스
public class GetNumbers {

    public List<Integer> extractNumbers(String input) {
        String defaultDelimiter = ",|:";
        String customDelimiter = "";
        String numbersPart = input;

        // 커스텀 구분자인지 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n"); //
            customDelimiter = input.substring(2, delimiterEndIndex); //
            numbersPart = input.substring(delimiterEndIndex + 2); //

            // 로그 출력
            System.out.println("Custom delimiter: " + customDelimiter);
            System.out.println("Numbers part: " + numbersPart);
        }

        // 구분자 설정
        String delimiter = customDelimiter.isEmpty() ? defaultDelimiter : customDelimiter;
        String[] tokens = numbersPart.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            // 숫자로 변환 후 리스트에 추가
            if (!token.isEmpty()) { // 빈 문자열이 아닌 경우에만 숫자로 변환
                numbers.add(Integer.parseInt(token));
            }
        }
        return numbers;
    }
}
