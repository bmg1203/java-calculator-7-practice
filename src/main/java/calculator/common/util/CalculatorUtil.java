package calculator.common.util;

import calculator.common.constant.RegexPatterns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorUtil {

    private CalculatorUtil() {};

    public static List<Integer> getNumberList(String inputValue) {
        List<String> delimiters = extractDelimiter(inputValue);

        return splitByDelimiters(delimiters, formattingString(inputValue));
    }

    public static List<String> extractDelimiter(String inputValue) {
        Pattern pattern = Pattern.compile(RegexPatterns.CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(inputValue);
        List<String> delimiters = new ArrayList<>();

        if (inputValue.contains(",")) delimiters.add(",");

        if (inputValue.contains(":")) delimiters.add(":");

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiters.add(customDelimiter);
        }

        return delimiters;
    }

    public static List<Integer> splitByDelimiters(List<String> delimiters, String inputValue) {
        String combinedDelimiters = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        return Arrays.stream(Pattern.compile(combinedDelimiters).split(inputValue))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String formattingString(String inputValue) {
        return inputValue.replaceAll(RegexPatterns.CUSTOM_DELIMITER, "");
    }
}
