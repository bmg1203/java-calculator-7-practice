package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void run() {
        String formula = input();

    }
}
