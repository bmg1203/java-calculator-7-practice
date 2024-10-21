package calculator.model;

public abstract class Delimiter {
    protected String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public abstract void validate();
}
