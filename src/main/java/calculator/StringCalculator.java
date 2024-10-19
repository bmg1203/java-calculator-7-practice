package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    public void run() {
        printInputPrompt();

        String input = Console.readLine();
        UserInput userInput = new UserInput(input);
        boolean isCustomDelimiter = userInput.isCustom();
        String defaultDelimiter = "[,:]";

        DefaultDelimiter defaultDelimiters = new DefaultDelimiter(defaultDelimiter);
        DelimiterResult delimiterResult = new DelimiterResult(defaultDelimiters.getDefaultDelimiter());

        if (isCustomDelimiter) {
            delimiterResult = generateDelimiterResult(userInput, delimiterResult);
            input = userInput.extractNumbersPart();
        }

        DelimitedNumbers delimitedNumbers = new DelimitedNumbers(input, delimiterResult);
        String[] separatedNumbers = generateSeparatedNumbers(delimitedNumbers, delimiterResult);
        Numbers numbers = new Numbers(separatedNumbers);

        int sum = calculateTotalSum(numbers);

        printResult(sum);

    }

    private static void printResult(int sum) {
        System.out.println("결과 : " + sum);
    }

    private static void printInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private DelimiterResult generateDelimiterResult(UserInput userInput, DelimiterResult delimiterResult) {
        String combineDelimiter = generateCombineDelimiter(userInput, delimiterResult);
        return new DelimiterResult(combineDelimiter);
    }

    private int calculateTotalSum(Numbers numbers) {
        int sum = 0;
        for (String stringNumbers : numbers.getNumbers()) {
            Number number = new Number(stringNumbers);
            sum += Integer.parseInt(number.getNumber());
        }
        return sum;
    }

    private String generateCombineDelimiter(UserInput userInput, DelimiterResult delimiterResult) {
        String extractCustomDelimiter = userInput.extractCustomDelimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter(extractCustomDelimiter);
        return combineDelimiter(delimiterResult, customDelimiter.getCustomDelimiter());
    }

    private String[] generateSeparatedNumbers(DelimitedNumbers delimitedNumbers, DelimiterResult delimiterResult) {
        return delimitedNumbers.getStringNumbers().split(delimiterResult.getDelimiterResult());
    }

    private String combineDelimiter(DelimiterResult delimiterResult, String customDelimiter) {
        return delimiterResult.getDelimiterResult().replace("]", customDelimiter + "]");
    }


}
