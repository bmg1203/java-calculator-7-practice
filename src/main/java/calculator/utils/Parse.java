package calculator.utils;

import java.util.List;

public class Parse {

    public static List<String> parseSeparators(List<String> separators, String input) {
        String separator = String.join("|", separators);
        return List.of(input.split(separator));
    }
}
