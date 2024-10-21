package calculator;

import camp.nextstep.edu.missionutils.Console;
import validator.InputValidator;


public class Application {
    public static void main(String[] args)  {

        // 사용자에게 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String input = Console.readLine();

        // 올바른 값인지 입력값 검증
        InputValidator.validateInput(input);

        // 덧셈 수행
        int result = SumCalculator.add(input);
        System.out.println("결과 : " + result);

    }

}

