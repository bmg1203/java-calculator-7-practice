package calculator;

import static calculator.ParsingInput.executeParsingInput;

import calculator.exception.InputValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final String INPUT;
    private final String TOKEN;
    private final String REGEX = "//(.)\\\\n";

    public Calculator(String input) {
        InputValidationException.isEmpty(input);
        INPUT = input;
        TOKEN = checkCustomToken(INPUT);
    }

    public void run() {
        int[] parsedInput = executeParsingInput(INPUT, TOKEN);
        int result = sumArray(parsedInput);
        printSum(result);
    }

    private String checkCustomToken(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String token = matcher.group(1);
            return "[,:" + token + "]";
        }
        return "[,:]";
    }

    private int sumArray(int[] intArray) {
        int sum = 0;
        for (int number : intArray) {
            sum += number;
        }
        return sum;
    }

    private void printSum(int result) {
        System.out.println("결과 : " + result);
    }

    public static void printStart() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
