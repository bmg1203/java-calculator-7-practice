package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String userInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        return input;
    }
}
