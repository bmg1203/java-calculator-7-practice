package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Processor processor = new Processor(input);
        int result = processor.execute();
        System.out.println("결과 : " + result);
    }
}
