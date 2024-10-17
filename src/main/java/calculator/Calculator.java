package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final String INPUT;
    private final String TOKEN;
    private final String REGEX = "//(.)\\\\n|//(.)(?=\\n)";

    public Calculator(String input) {
        INPUT = input;
        TOKEN = checkCustomToken(INPUT);
    }

    private String checkCustomToken(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String token = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
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
}
