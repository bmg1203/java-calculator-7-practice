package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] delimiterAndContent = getCustomDelimiterAndContent(input);

        String customDelimiter = delimiterAndContent[0];
        String contentWithoutDelimiter = delimiterAndContent[1];

        String[] numberArray;
        int resultSum;

        checkValidDelimiters(contentWithoutDelimiter, customDelimiter);
        numberArray = splitByDelimiter(contentWithoutDelimiter, customDelimiter);
        resultSum = calculateSum(numberArray);

        System.out.print("결과 : " + resultSum);
    }

    public static String[] getCustomDelimiterAndContent(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex);
                String content = input.substring(delimiterEndIndex + 2);
                return new String[]{customDelimiter, content};
            }
        }
        return new String[]{"", input};
    }

    public static void checkValidDelimiters(String content, String delimiter) {
        String validDelimiterPattern = "[\\d" + delimiter + ",:]*";

        if (!content.matches(validDelimiterPattern)) {
            throw new IllegalArgumentException("Error: Invalid delimiters");
        }
    }

    public static String[] splitByDelimiter(String content, String delimiter) {
        if (content == null || content.isEmpty()) {
            return new String[]{"0"};
        }

        String splitPattern = "[" + delimiter + ",:]";

        return content.split(splitPattern);
    }

    public static int calculateSum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }

}