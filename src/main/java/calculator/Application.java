package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        String input = Console.readLine();
        String input = "//;\\n1";

        Calculator calculator = new Calculator(input);
        System.out.println(calculator.getResult());
    }
}
