package calculator;

import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.Delimiter;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요."); // 사용자 입력
        String input = Console.readLine();

        input = input.replaceAll("\\s+", "");  // 입력의 모든 공백 제거

        Delimiter delimiter = new CustomDelimiter(); // 구분자 객체
        Calculator calculator = new Calculator(delimiter); // 구분자 객체를 전달하여 계산 객체 생성
        int result = calculator.add(input); // 덧셈 계산

        System.out.println("결과 : " + result); // 결과 출력
    }
}
