package calculator.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorView {

    private BufferedReader reader;

    public CalculatorView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * 사용자로부터 문자열 입력을 받아 반환합니다.
     * @return 입력한 문자열 또는 예외 오류
     */
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "입력이 잘못되었습니다.";
        }
    }

    /**
     * 계산한 결과를 출력합니다.
     * @param result
     */
    public void showResult(int result) {
        System.out.println("결과 : " + result);
    }

    /**
     * 인자로 받은 message를 에러 문구로 출력합니다.
     * @param message
     */
    public void showError(String message) {
        System.err.println("에러: " + message);
    }
}
