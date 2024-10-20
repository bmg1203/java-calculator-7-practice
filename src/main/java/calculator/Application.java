package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 콘솔에서 사용자에게 덧셈할 문자열을 요청하는 메시지를 띄우고, 입력 받는 기능
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println(userInput);

        // try-catch문을 통한 IllegalArgumentException 예외 처리
        try {
            // 입력받은 문자열이 없으면 콘솔에 0을 반환하고, 있으면 구분자 추출 후 파싱하여 계산
            if (userInput.isEmpty()) {
                System.out.println(0);
            } else {
                // 입력된 문자열에서 구분자를 추출하고 파싱하는 기능
                Parser parser = new Parser();
                List<String> numberList = parser.extractNumberList(userInput);
                List<Integer> parsedNumberList = parser.parseNumberList(numberList);

                Calculator calculator = new Calculator();
                Integer result = calculator.sum(parsedNumberList);
                System.out.println("결과 : " + result);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}