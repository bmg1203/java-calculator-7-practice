package calculator.service;

import static calculator.service.CustomSeparatorsRegex.END_REGEX;
import static calculator.service.CustomSeparatorsRegex.END_SEPARATOR;
import static calculator.service.CustomSeparatorsRegex.START_REGEX;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService implements Service {

    private final List<String> separators = new ArrayList<>();


    @Override
    public void createSeparators() {
        for (Separators separator : Separators.values()) {
            separators.add(separator.getSeparator());
        }
    }

    @Override
    public boolean isCustomSeparator(String input) {
        boolean result = input.matches(START_REGEX.getRegex()) && input.matches(END_REGEX.getRegex());
        return result;
    }

    @Override
    public void saveCustomSeparator(String input) {
        int endRegexIndex = input.indexOf(END_SEPARATOR.getRegex());
        separators.add(String.valueOf(input.charAt(endRegexIndex - 1)));
    }

    @Override
    public String removeCustomPart(String input) {
        int endRegexIndex = input.indexOf(END_SEPARATOR.getRegex()) + END_SEPARATOR.getRegex().length();
        return input.substring(endRegexIndex);
    }

    @Override
    public String[] separateInput(String input) {
        String separatorsRegex = "[" + String.join("", separators) + "]";
        return input.split(separatorsRegex);
    }

    @Override
    public int calculate(String[] nums) {
        if (nums[0].isEmpty()) {
            return 0;
        }

        int result = 0;
        for (String num : nums) {
            if (!num.matches("0|[1-9][0-9]*")) {
                throw new IllegalArgumentException();
            }
            result += Integer.parseInt(num);
        }
        return result;
    }
}
