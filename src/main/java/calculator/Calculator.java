package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String input) {

        //공백인 경우 0을 반환함
        if (input.isEmpty()) {
            return 0;
        }

        String delimeter = "";

        //입력값 앞부분이 '//'인 경우 customDelimiter 실행함
        if (input.startsWith("//")) {
            String[] customResult = customDelimiter(input);
            delimeter = customResult[0];
            input = customResult[1];
        }

        List<Integer> numbers = extractNumbers(input, delimeter);

        int sum = sumCalculator(numbers);

        return sum;
    }

    //커스텀 구분자 추출 후 커스텀 구분자와 커스텀 구분자를 제거한 입력값을 반환
    public String[] customDelimiter(String input) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        int index = 0;
        //숫자가 첫번째로 나오는 인덱스 기준으로 설정
        if (matcher.find()) {
            index = matcher.start();
        } else {
            //숫자가 없는 경우 예외 처리
            if (input.endsWith("\\n")) {
                System.out.println("결과 : 0");
                System.exit(0);
            } else {
                throw new IllegalArgumentException();
            }
        }
        //커스텀 구분자 추출
        String delimiter = input.substring(2, index - 2);
        //커스텀 구분자 부분(앞부분) 제거한 입력값
        String newInput = input.substring(index);
        return new String[]{delimiter, newInput};
    }

    //기본, 커스텀 구분자 기준으로 숫자 추출
    public List<Integer> extractNumbers(String input, String delimiter) {
        //메타문자 포함 할 수도 있어서 이스케이프 처리
        String escapedDelimiter = Pattern.quote(delimiter);
        String[] extracted = input.split(",|:|" + escapedDelimiter);
        List<Integer> numbers = new ArrayList<>();
        //정수형 리스트로 변환
        for (String a : extracted) {
            //예외 처리 - 음수이거나 숫자가 아닌경우
            try {
                int number = Integer.parseInt(a);
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }

    public int sumCalculator(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
