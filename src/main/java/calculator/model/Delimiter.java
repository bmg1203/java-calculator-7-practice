package calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static Set<String> delimiter;

    public Delimiter() {
        delimiter = new HashSet<>();
        delimiter.add(",");
        delimiter.add(":");
    }

    public static String[] splitWithCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression.replace("\\n", "\n"));
        if (m.find()) {
            String[] splitedExpression = splitExpression(m);
            return splitedExpression;
        }
        return splitWithDelimiter(expression);
    }

    private static String[] splitExpression(Matcher m) {
        String customDelimiter = m.group(1);
        delimiter.add(customDelimiter);
        String delimiterToUse = customAndBasicDelimiter();
        String[] splitedExpression = m.group(2).split(delimiterToUse);
        checkExpressionHasInvalidExpression(splitedExpression);
        return splitedExpression;
    }

    private static void checkExpressionHasInvalidExpression(String[] splitedExpression) {
        Arrays.stream(splitedExpression)
                .forEach(i -> {
                    validOperandHasInvalidDelimiter(i);
                });
    }

    private static void validOperandHasInvalidDelimiter(String i) {
        for (char s : i.toCharArray()) {
            if (!Character.isDigit(s)) {
                throw new NumberFormatException("허용되지 않은 구분자가 존재합니다");
            }
        }
    }

    public static String[] splitWithDelimiter(String expression) {
        return expression.split(",|:");
    }

    private static String customAndBasicDelimiter() {
        return delimiter.stream()
                .collect(Collectors.joining("|"));
    }

}
