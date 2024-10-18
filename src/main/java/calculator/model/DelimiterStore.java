package calculator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DelimiterStore {

    private static final DelimiterStore INSTANCE = new DelimiterStore();

    private final List<String> delimiterStore = new ArrayList<>(DefaultDelimiter.getAll());

    private DelimiterStore() {
    }

    public static DelimiterStore getInstance() {
        return INSTANCE;
    }

    public void addDelimiters(List<String> delimiters) {
        delimiterStore.addAll(delimiters);
    }

    public List<String> getAllDelimiters() {
        return new ArrayList<>(new HashSet<>(delimiterStore));
    }

    public void clear() {
        delimiterStore.clear();
    }
}
