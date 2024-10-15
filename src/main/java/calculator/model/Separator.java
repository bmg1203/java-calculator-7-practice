package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private List<String> separators;
    public Separator() {
        separators = new ArrayList<>();
        separators.add(";");
        separators.add(",");
    }

    public List<String> getSeparators() {
        return separators;
    }

    public void addSeparator(String separator) {
        separators.add(separator);
    }
}
