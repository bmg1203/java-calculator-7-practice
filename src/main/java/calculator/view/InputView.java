package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_FORMAT = "덧셈할 문자열을 입력해 주세요.";

    public String readCommand() {
        System.out.println(INPUT_FORMAT);
        return Console.readLine();
    }
}
