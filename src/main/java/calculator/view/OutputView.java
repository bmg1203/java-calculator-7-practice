package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public void printError(String message) {
        System.out.println("오류: " + message);
    }
}
