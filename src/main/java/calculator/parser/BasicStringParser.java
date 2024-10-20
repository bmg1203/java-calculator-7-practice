package calculator.parser;

import java.util.Arrays;
import java.util.List;

public class BasicStringParser implements StringParser{

    private static final String BASIC_DELIMITER_REGEX = "[,|:]";

    @Override
    public List<String> parse(String input) {
        return Arrays.stream(input.split(BASIC_DELIMITER_REGEX)).toList();
    }
}