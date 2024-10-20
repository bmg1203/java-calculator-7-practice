package calculator.service;

import calculator.model.CalculationInput;
import calculator.util.InputValidator;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final String DEFAULT_DELIMITER = ",:";
    private static final String CUSTOM_DELIMITER_INPUT_REGEX = "^//(.*?)\\\\n(.*)";
    private static final String EMPTY_INPUT = "";

    InputValidator inputValidator = new InputValidator();

    public int calculateString(String userInput) {

        int result = 0;
        CalculationInput calculationInput = getCalculationInput(userInput);

        if (!calculationInput.inputString().equals(EMPTY_INPUT)) {
            ArrayList<Integer> extractedNumbers = extractNumbers(calculationInput);
            result = calculate(extractedNumbers);
        }

        return result;
    }

    private CalculationInput getCalculationInput(String userInput) {

        String delimiter = DEFAULT_DELIMITER;
        String inputString = userInput;

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_INPUT_REGEX);
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.matches()) {
            delimiter = matcher.group(1);
            inputString = matcher.group(2);
        }

        if (inputString.trim().isEmpty()) {
            inputString = EMPTY_INPUT;
        }

        return new CalculationInput(delimiter, inputString);
    }

    private ArrayList<Integer> extractNumbers(CalculationInput calculationInput) {

        String inputString = calculationInput.inputString();
        String delim = calculationInput.delimiter();

        ArrayList<Integer> numbersToSum = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, delim);

        while (stringTokenizer.hasMoreTokens()) {
            int number = inputValidator.validateStringToken(stringTokenizer.nextToken());
            numbersToSum.add(number);
        }

        return numbersToSum;
    }

    private int calculate(ArrayList<Integer> numbersToSum) {

        int sum = 0;
        for (int number : numbersToSum) {
            sum += number;
        }

        return sum;
    }
}
