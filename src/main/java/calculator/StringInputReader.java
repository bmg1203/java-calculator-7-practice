package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringInputReader {
    public String readStringInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
