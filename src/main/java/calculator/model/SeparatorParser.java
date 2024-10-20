package calculator.model;

import calculator.validator.ParserValidator;
import java.util.Arrays;
import java.util.HashMap;

public class SeparatorParser {
    private final String CUSTOM_SEPARATOR_FORMAT_STRING = "//|\\\\n";
    private final String[] BASIC_SEPARATOR = new String[]{",", ":"};
    private final ParserValidator parserValidator = new ParserValidator();

    public HashMap<String, String> parseSeparator(String input) {
        String[] splitInputString = Arrays.stream(input.split(CUSTOM_SEPARATOR_FORMAT_STRING))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        int numberStringIndex = 0;
        int separatorStringIndex = 0;

        HashMap<String, String> separatorAndNumberString = new HashMap<>();

        String separators = splitInputString[separatorStringIndex];

        for (int basicSeparatorIndex = 0; basicSeparatorIndex < BASIC_SEPARATOR.length; basicSeparatorIndex++) {
            separators += BASIC_SEPARATOR[basicSeparatorIndex];
        }

        separatorAndNumberString.put("separator", separators);

        separatorAndNumberString.put("type", "numberStringWithCustomSeparator");
        separatorAndNumberString.put("numberString", splitInputString[++numberStringIndex]);

        return separatorAndNumberString;
    }

}
