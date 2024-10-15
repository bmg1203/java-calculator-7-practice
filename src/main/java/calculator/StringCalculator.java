package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class parses the input string and calculates the sum of a list of integers.
 */
public class StringCalculator {

    /**
     * This method returns default separators
     * @return default separators
     */
    private ArrayList<String> getDefaultSeparator() {
        return new ArrayList<String>(List.of(",", ":"));
    }

    /**
     * This method return custom separators
     * @param input The string to get custom separator
     * @return A list of default separators + custom separator
     */
    private ArrayList<String> getCustomSeparator(String input) {
        ArrayList<String> separators = getDefaultSeparator();

        String custom_separator = input.split("\\\\n")[0];
        custom_separator = custom_separator.substring(2);
        separators.add(custom_separator);

        return separators;
    }

    /**
     * This method return numbers separated by separators
     * @param input The string to get numbers
     * @param separators The string to split numbers
     * @return A list of numbers
     */
    private ArrayList<Integer> getNumbers(String input, ArrayList<String> separators) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String number_string;
        if (input.startsWith("//")) {
            number_string = input.split("\\\\n")[1];
        } else {
            number_string = input;
        }

        String separator = String.join("|", separators);

        for (String num : number_string.split(separator)) {
            try {
                int number = Integer.parseInt(num);
                if (number <= 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                numbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자의 형식이 올바르지 않습니다.");
            }
        }

        return numbers;
    }

    /**
     * This method return sum of numbers separated by separators
     * @param input The string to sum
     * @return A sum of input numbers
     */
    public Integer calculate(String input) {

        ArrayList<String> separators = new ArrayList<String>();

        if (input.startsWith("//")) {
            separators = getCustomSeparator(input);
        } else {
            separators = getDefaultSeparator();
        }

        try {
            ArrayList<Integer> numbers = getNumbers(input, separators);

            Integer sum = 0;

            for (Integer number : numbers) {
                sum += number;
            }

            return sum;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
