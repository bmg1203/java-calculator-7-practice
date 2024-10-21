package calculator;

import camp.nextstep.edu.missionutils.Console;


public class CalculatorDisplay implements ICalculatorDisplay {

    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputMessage = "결과 : %d";

    public void show() {
        // 사용자 입력 받기
        System.out.println(inputMessage);
        String input = getPromptUserInput();

        // 숫자의 합 계산하기
        Calculator calculator = new Calculator();
        int result = calculator.sum(input);

        // 결과 출력하기
        System.out.printf(outputMessage, result);
    }

    private String getPromptUserInput() {
        String input = Console.readLine();
        Console.close();

        return input;
    }

    @Override
    public String getPromptInput() {
        System.out.println(inputMessage);

        String input = Console.readLine();
        Console.close();

        return input;
    }

    @Override
    public void printResult(int result) {
        System.out.printf(outputMessage, result);
    }
}
