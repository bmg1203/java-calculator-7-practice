package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        DelimiterParser delimiterParser = new DelimiterParser(userInput);
        String[] numbers = delimiterParser.parseNumbers();

        StringCalculator stringCalculator = new StringCalculator();
        int sumResult = stringCalculator.sum(numbers);

        System.out.println("결과 : " + sumResult);
    }
}
