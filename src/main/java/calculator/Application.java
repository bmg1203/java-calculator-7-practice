package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        runCalculator();
    }

    public static void runCalculator() {
        String input = getInput();
        String[] strings = splitInput(input);
        long[] numbers = parseToLongArray(strings);
        long result = calculateSum(numbers);

        System.out.println("결과 : " + result);
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static String[] splitInput(String input) {
        if (isCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            String numbersPart = input.substring(input.indexOf("\\n") + 2);
            return numbersPart.split(customDelimiter);
        } else {
            return input.split("[,:]");
        }
    }

    public static boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public static String extractCustomDelimiter(String input) {
        // '\\'는 다른 특수문자보다 먼저 처리되어야 하므로 배열의 맨 앞에 위치해야 함
        String[] SPECIAL_CHARS = {"\\", "^", "$", ".", "*", "+", "?", "|", "(", ")", "[", "]"};
        int delimiterEndIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, delimiterEndIndex);

        if (customDelimiter.isEmpty()) {
            System.out.println("커스텀 구분자를 입력하지 않았습니다.");
            throw new IllegalArgumentException();
        }

        for (String character : SPECIAL_CHARS) {
            if (customDelimiter.contains(character)) {
                customDelimiter = customDelimiter.replace(character, "\\" + character);
            }
        }

        return customDelimiter;
    }

    public static long[] parseToLongArray(String[] strings) {
        long[] longArray = new long[strings.length];

        for (int i = 0; i < strings.length; i++) {
            longArray[i] = parseToLong(strings[i]);
        }

        return longArray;
    }

    public static long parseToLong(String string) {
        if (string.isEmpty()) {
            return 0;
        } else {
            try {
                long number = Long.parseLong(string);

                if (number <= 0) {
                    System.out.println("양수만 입력할 수 있습니다.");
                    throw new IllegalArgumentException();
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private static long calculateSum(long[] numbers) {
        long sum = 0;

        for (long number : numbers) {
            sum += number;
        }

        return sum;
    }
}
