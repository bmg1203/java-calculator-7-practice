package calculator.view;

public class OutputView {
    private static final String RESULT = "결과 : ";


    public void printResult(final long number) {
        System.out.println(RESULT + number);
    }
}
