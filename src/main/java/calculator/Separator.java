package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private final List<String> separators;
    private final String defaultSeparator[] = {",", ":"};

    public Separator() {
        this.separators = new ArrayList<>();
        for (String separator : defaultSeparator) {
            separators.add(separator);
        }
    }

    public List<String> getSeparators() {
        return separators;
    }

    public void addSeparator(String separator) {
        separators.add(separator);
    }
}
