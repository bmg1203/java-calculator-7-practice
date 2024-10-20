package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = add(input);
        System.out.println("결과 : " + result);
    }
}
