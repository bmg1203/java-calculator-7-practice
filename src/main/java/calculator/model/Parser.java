package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));
    private String input;

    public Parser(String input) {
        this.input = input;
    }

    private boolean usesCustomValidator() {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
}
