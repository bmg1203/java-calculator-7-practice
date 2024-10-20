package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application{

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();  // 문자열 입력

        Calculator calculator = new Calculator();
        int sum = calculator.calculate(s);

        if (sum == -1){
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + sum);
    }
}
