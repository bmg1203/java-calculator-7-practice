package calculator.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SeparatorSet {

    private final Set<Separator> separators;

    public SeparatorSet() {
        this.separators = new HashSet<>();
    }

    public String toRegexString() {
        return Separator.getAllSeparatorsRegex(separators);
    }

    public void addSeparator(Separator separator) {
        separators.add(separator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SeparatorSet that = (SeparatorSet) o;
        return Objects.equals(separators, that.separators);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(separators);
    }
}
