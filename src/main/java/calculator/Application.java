package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calc = new Calculator();
    }
}

class Calculator {

    static Str str;
    static char[] delimiterArr;

    Calculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        str = new Str(Console.readLine());
    }

}

class Str {

    private static String string;

    Str(String string) {
        this.string = string;
    }

    boolean checkingCustomDelimiter() {
        return (string.substring(0, 2).equals("//") && string.charAt(3) == '\\'
            && string.charAt(4) == 'n');

    }
}