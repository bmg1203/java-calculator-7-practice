package calculator.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String view() {

        System.out.println("덧셈할 문자열을 입력해주세요: ");
        String userInput = Console.readLine();
        Console.close();
        return userInput;
    }
}
