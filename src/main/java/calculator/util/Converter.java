package calculator.util;

import java.util.List;

public class Converter {
    public List<Integer> convertToInteger(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
