package calculator.util;

import calculator.common.Delimiters;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberExtractor {
    private static final String REGEX_OR = "|";
    private static final Long ZERO = 0L;

    private NumberExtractor() {
    }

    public static List<Long> parseNumbers(String cleanedInput, Delimiters delimiters) {
        if (cleanedInput.isEmpty()) {
            return List.of(ZERO);
        }

        String delimiterPattern = delimiters.getDelimiters().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining(REGEX_OR));

        return Arrays.stream(cleanedInput.split(delimiterPattern))
                .map(Long::parseLong)
                .toList();
    }
}