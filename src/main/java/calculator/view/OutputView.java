package calculator.view;

public class OutputView {
    private final static String RESULT_MESSAGE = "결과 : ";

    public void printResultMessage(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
