package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            if (input == null || input.trim().isEmpty()) {
                System.out.println("결과 : 0");
                return;
            }

            Parser parser = new Parser(new DelimiterExtractor());
            Validator validator = new Validator();
            StringAddCalculator calculator = new StringAddCalculator(parser, validator);

            int result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
