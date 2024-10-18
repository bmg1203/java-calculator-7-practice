package calculator.validation;

public enum RegexPattern {
    ONLY_NUMBER("^[0-9]+$");
    private final String value;

    RegexPattern(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
