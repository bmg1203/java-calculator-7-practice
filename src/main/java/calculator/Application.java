package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {



    public static void main(String[] args) throws IllegalArgumentException{
        Calculator calculator = new Calculator(new InputStringParser(), new ListCalculator());

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        long sumResult = calculator.calculate(inputString);
        System.out.println("결과 : " + sumResult);

    }
}
