package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public List<Number> parse(final String userInput) {
        String input = userInput;
        String regex = "//(.*?)\\\\n";
        String delimiter = getDelimiter(input, regex);

        if (isCustomDelimiter(input)) {
            input = input.replaceAll(regex, "");
        }

        String[] tokens = splitInput(input, delimiter);

        return getNumbers(tokens);
    }

    private List<Number> getNumbers(final String[] tokens) {
        List<Number> numbers = new ArrayList<>();

        for (String token : tokens) {
            Number number = parseNumber(token);
            validateNegative(number);
            numbers.add(parseNumber(token));
        }

        return numbers;
    }

    private Number parseNumber(String token) {
        if (token.isEmpty() || token.equals(" ")) {
            return 0;
        }

        try {
            if (token.contains(".")) {
                return Double.parseDouble(token);
            } else {
                return Integer.parseInt(token);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
        }
    }

    private String[] splitInput(String input, String delimiter) {
        String[] tokens = input.split(delimiter);

        if (tokens.length == 0) {
            throw new IllegalArgumentException("구분자로만 이루어진 입력값은 허용되지 않습니다. 프로그램을 종료합니다.");
        }

        return tokens;
    }

    private String getDelimiter(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String delimiter = "[,:]";

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("구분자가 지정되지 않았습니다. 프로그램을 종료합니다.");
            }
            delimiter = Pattern.quote(customDelimiter);
        }

        return delimiter;
    }

    private boolean isCustomDelimiter(String userInput) {
        boolean isCustomDelimiter = userInput.startsWith("//") && userInput.startsWith("\\n", 3);

        if (userInput.startsWith("//") && !userInput.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 선언 형식이 잘못되었습니다. 올바른 형식은 //구분자\\n 입니다. 프로그램을 종료합니다.");
        }

        return isCustomDelimiter;
    }

    private void validateNegative(Number number) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException("음수를 입력하였습니다. 프로그램을 종료합니다.");
        }
    }
}
