package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        input = Console.readLine();    // 사용자로부터 문자열 입력 받기

        System.out.println(input);    //Debug
    }
}
