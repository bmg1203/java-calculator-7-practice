package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 계산기 로직 실행
            int result = StringCalculator.splitAndSum(input);

            // 결과 출력
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러 발생: " + e.getMessage());
        }
    }
}
