package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String DEFAULT_COMMA = ",";
    private static final String DEFAULT_COLON = ":";
    private static final String DOT = ".";
    private final List<String> availableSeparators;
    private final List<String> extractedNumbers;

    public Separator(String numbers) {
        availableSeparators = new ArrayList<>(List.of(DEFAULT_COMMA, DEFAULT_COLON));
        extractedNumbers = new ArrayList<>();
        validate(numbers);
    }
    private void validate(String numbers) {
        if(numbers.startsWith("//")) {
            int newlineIndex = validateSpecialCase(numbers);
            numbers = addCustomSeparator(numbers, newlineIndex);
        }
        validateSeparators(numbers);
    }
    private int validateSpecialCase(String numbers) {
        int newlineIndex;
        if(numbers.contains("\\n")) {
            newlineIndex = numbers.indexOf("\\n");
        }
        else {
            newlineIndex = numbers.indexOf("\n");
        }

        if(newlineIndex == -1) {
            throw new IllegalArgumentException();
        }

        return newlineIndex;
    }

    private String addCustomSeparator(String numbers, int newlineIndex) {
        String customSeparator = numbers.substring(2, newlineIndex);
        if(customSeparator.length() != 1) {
            throw new IllegalArgumentException();
        }
        if(Character.isDigit(customSeparator.charAt(0))) {
            throw new IllegalArgumentException();
        }
        if(customSeparator.equals(DOT)) {
            throw new IllegalArgumentException();
        }
        availableSeparators.add(customSeparator);
        return numbers.substring(newlineIndex+2);
    }

    private void validateSeparators(String numbers) {
        for(char ch : numbers.toCharArray()) {
            if(!Character.isDigit(ch) && ch != DOT.charAt(0) && !availableSeparators.contains(String.valueOf(ch))) {
                throw new IllegalArgumentException();
            }
        }
        extractNumbers(numbers);
    }

    private void extractNumbers(String numbers) {
        StringBuilder number = new StringBuilder();
        for(int i = 0; i < numbers.length(); i ++) {
            char currentChar = numbers.charAt(i);
            if(Character.isDigit(currentChar) || currentChar == '.') {
                number.append(numbers.charAt(i));
                continue;
            }
            extractedNumbers.add(number.toString());
            number.setLength(0);
        }
        extractedNumbers.add(number.toString());
    }

    public List<String> getExtractedNumbers() {
        return extractedNumbers;
    }
}
