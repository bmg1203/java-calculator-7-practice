package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine(); // Input 입력 받기
        Calculator calculator = new Calculator(input);
        // Calculator의 결과를 받아서 출력
    }
}