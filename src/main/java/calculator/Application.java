package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.domain.computer.Adder;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Adder adder = new Adder();
        adder.inPut();
    }
}
