package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String[] checkInput (String input, StringBuilder delimiter) {
        String validatedCustomDelimiterInput = checkCustomDelimiter(input, delimiter);
        if (!checkArguments(validatedCustomDelimiterInput, delimiter))
            throw new IllegalArgumentException("wrong arguments");
        return checkDuplicateDelimiter(validatedCustomDelimiterInput.split(delimiter.toString()));
    }

    public static String checkCustomDelimiter (String input, StringBuilder delimiter) {
        String customInput = input;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1)
                throw new IllegalArgumentException("custom delimiter error");
            delimiter.append(input, 2, delimiterEndIndex);
            customInput = input.substring(delimiterEndIndex + 2);
        }
        delimiter.append("]");
        return customInput;
    }

    public static boolean checkArguments (String input, StringBuilder delimiter) {
        String regex = "^[0-9" + delimiter.substring(1) + "+$";
        return input.matches(regex);
    }

    public static String[] checkDuplicateDelimiter (String[] splitInput) {
        for (String str : splitInput) {
            if (str.equals(""))
                throw new IllegalArgumentException("delimiter duplicate");
        }
        return splitInput;
    }

    public static int sumArguments (String[] splitInput) {
        int sum = 0;
        for (String input : splitInput) {
            sum += Integer.parseInt(input);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringBuilder delimiter = new StringBuilder("[,:");
        String input = Console.readLine();
        String[] splitInput = checkInput(input, delimiter);
        System.out.println("결과 : " + sumArguments(splitInput));
    }
}
