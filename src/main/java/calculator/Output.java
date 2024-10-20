package calculator;

public class Output {

    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
