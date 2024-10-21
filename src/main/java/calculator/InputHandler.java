package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        OutputHandler outputHandler = new OutputHandler();

        if (input.isEmpty()) {
            outputHandler.printZeroResult();
            return "";
        }

        return input;
    }
}
