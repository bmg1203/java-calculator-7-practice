package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
