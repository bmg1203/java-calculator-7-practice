package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public static String inputNumber() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
