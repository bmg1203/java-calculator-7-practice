package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = parseDelimiter(input);

        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int parsedNumber = validateAndParse(number);
                sum += parsedNumber;
            }
        }

        return sum;
    }

    public static String[] parseDelimiter(String input) {
        if (input.contains("//") && !input.startsWith("//")) {
            throw new IllegalArgumentException("잘못된 형식의 입력: " + input);
        }

        String[] delimiters = {",", ":"};

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.?)\\\\n.*").matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                delimiters = new String[]{",", ":", customDelimiter};
                input = input.substring(5);
            }
        }

        String delimiter = "[" + Arrays.stream(delimiters).reduce("", String::concat) + "]";
        return input.split(delimiter);
    }

    public static int validateAndParse(String number) {
        int result;

        try {
            result = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력값 : " + number);
        }

        if (result < 0) {
            throw new IllegalArgumentException("음수 입력: " + number);
        }

        return result;
    }
}
