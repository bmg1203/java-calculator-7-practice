package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String USER_NUMBERS = "덧셈할 문자열을 입력해 주세요.";

    public static String readUserNumbers() {
        System.out.print(USER_NUMBERS + "\n");
        String input = Console.readLine();
        return input;
    }

}
