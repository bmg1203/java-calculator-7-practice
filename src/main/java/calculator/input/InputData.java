package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
    protected static String input;

    private InputData(){
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        return input;
    }
}
