package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private String string;
    private final List<Integer> numbers;
    private final List<Character> separators;

    public Separator(String string) {
        this.string = string;
        numbers = new ArrayList<>();
        separators = new ArrayList<>();
        separators.add(',');
        separators.add(':');
    }

    public void extractSeparatorFromInput() {
        while (hasCustomSeparator(string)) {
            char customSeparator = string.charAt(2);
            if (isWrongSeparator(customSeparator)) {
                throw new IllegalArgumentException();
            }
            separators.add(customSeparator);
            string = string.substring(5);
        }
    }

    private boolean hasCustomSeparator(String string) {
        return string.indexOf("//") == 0 && string.indexOf("\\n") == 3;
    }

    private boolean isWrongSeparator(char separator) {
        return separator == '/' || separator == '\\' || separator == 'n' || (separator >= 48 && separator <= 57);
    }

    public boolean isValidFormula() {
        return string.matches(createRegex());
    }

    private String createRegex() {
        StringBuilder regex = new StringBuilder("^([0-9]+([");
        for (Character separator : separators) {
            regex.append(separator);
        }
        regex.append("][0-9]+)*)?$");
        return regex.toString();
    }

    public void separate() {
        while (!string.matches("([0-9]+)?")) {
            int index = getFirstSeparatorIndex();
            numbers.add(Integer.parseInt(string.substring(0, index)));
            string = string.substring(index + 1);
        }
        if (!string.isEmpty()) {
            numbers.add(Integer.parseInt(string));
        }
    }

    private int getFirstSeparatorIndex() {
        int idx = 0;
        for (; idx < string.length(); idx++) {
            if (!(string.charAt(idx) >= 48 && string.charAt(idx) <= 57)) {
                break;
            }
        }
        return idx;
    }

    public int calculateSum() {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
