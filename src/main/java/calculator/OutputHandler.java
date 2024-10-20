package calculator;

public class OutputHandler {
    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";

    public static void printResult(double result) {
        System.out.println(RESULT_MESSAGE_PREFIX + formatResult(result));
    }

    private static String formatResult(double result) {
        if (isInteger(result)) {
            return String.valueOf((int) result);
        }

        return String.valueOf(result);
    }

    private static boolean isInteger(double number) {
        return number == (int) number;
    }
}
