package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(input);
        System.out.println("결과 : " + result);
        scanner.close();
    }
}
