package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorDisplay {

    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";

    public void show(){
        // 1. 사용자 입력 받기
        System.out.println(inputMessage);
        String input = Console.readLine();
        Console.close();

        // 2. 커스텀 구분자 등록 여부 확인

        // 3. 구분자를 기준으로 숫자 분리하기

        // 4. 숫자의 합 계산하기

        // 5. 결과 출력하기
    }
}
