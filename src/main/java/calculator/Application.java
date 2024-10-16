package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        InputOutputService inputOutputService = new InputOutputService();

        String input = inputOutputService.fetchUserInput();
        List<String> splitString = stringCalculator.splitDelimiterAndNumbers(input);

        String customDelimiter = stringCalculator.extractDelimiter(splitString);

        String numbersCandidates = splitString.get(1);
        List<Double> numberList = stringCalculator.splitNumbersByDelimiter(numbersCandidates, customDelimiter);

        Double sum = stringCalculator.calculate(numberList);
        inputOutputService.printResult(sum);
    }
}
