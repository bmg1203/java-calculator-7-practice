package calculator.view;

import calculator.domain.Number;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    public static final int CUSTOM_DELIMITER_LENGTH = 1;

    private String delimiter = "[,:]";

    public int isCustomDelimiter(String input) {
        int length = CUSTOM_DELIMITER_PREFIX.length();
        int index = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && index == length + CUSTOM_DELIMITER_LENGTH) {
            delimiter = String.valueOf(input.charAt(length));
            return index + CUSTOM_DELIMITER_SUFFIX.length();
        }
        return 0;
    }

    public List<Number> parseNumbers(String input) {
        List<Number> parsedNumbers = new ArrayList<>();
        String[] Numbers = input.split(delimiter);
        for (String number : Numbers) {
            parsedNumbers.add(new Number(number));
        }
        return parsedNumbers;
    }
}
