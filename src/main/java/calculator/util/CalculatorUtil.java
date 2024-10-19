package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorUtil {
    public static final String CUSTOM_DELIMITER_REGEX = "^//(.*?)\\\\n";

    private CalculatorUtil() {};

    public static List<Integer> getNumberList(String inputValue) {
        List<String> delimiters = extractDelimiter(inputValue);

        return splitByDelimiters(delimiters, inputValue);
    }

    public static List<String> extractDelimiter(String inputValue) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(inputValue);
        List<String> delimiters = new ArrayList<>();

        if (inputValue.contains(",")) delimiters.add(",");

        if (inputValue.contains(":")) delimiters.add(":");
        if (matcher.find()) {
            String[] customDelimiters = matcher.group(1).split("\\|");

            for (String delimiter : customDelimiters) {
                delimiters.add(delimiter.trim());
            }
        }

        return delimiters;
    }

    public static List<Integer> splitByDelimiters(List<String> delimiters, String inputValue) {
        String combinedDelimiters = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        return Arrays.stream(inputValue.split(combinedDelimiters))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String formattingString(String inputValue) {
        return inputValue.replaceAll(CUSTOM_DELIMITER_REGEX, "");
    }
}
