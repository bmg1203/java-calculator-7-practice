package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : %d";

    public void showResultMessage(int result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}