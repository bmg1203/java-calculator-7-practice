package calculator.common;

import java.util.HashSet;
import java.util.Set;

public class Delimiters {
    public static final String DEFAULT_DELIMITER_COMMA = ",";
    public static final String DEFAULT_DELIMITER_COLON = ":";

    private final Set<String> delimiters;

    public Delimiters() {
        this.delimiters = new HashSet<>();
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);
    }

    public void addCustomDelimiters(Set<String> customDelimiters) {
        delimiters.addAll(customDelimiters);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }
}
