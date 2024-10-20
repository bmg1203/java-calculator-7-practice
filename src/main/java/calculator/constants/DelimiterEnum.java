package calculator.constants;

public enum DelimiterEnum {
    MINUS("-"),
    AND("|"),
    ZERO("0"),
    DEFAULT_DELIMITER(",|:"),
    DUPLICATE_DEFAULT_DELIMITER(".*[,:].*"),
    CUSTOM_DELIMITER_FORWARD("//"),
    CUSTOM_DELIMITER_PATTERN("//(.)\n(.*)"),
    CUSTOM_DELIMITER_BACKWARD("\n"),
    INPUT_DELIMITER_BACKWARD("\\n"),
    ALL_NUMBER("\\d+");

    private final String value;

    DelimiterEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}