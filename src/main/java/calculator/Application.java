package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String userInput = Console.readLine();
        int stringSum = new StringCalculator(userInput).stringSum();

        System.out.println("결과 : " + stringSum);
    }
}
