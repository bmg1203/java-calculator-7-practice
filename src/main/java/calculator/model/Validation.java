package calculator.model;

public class Validation {
    private static final String ZERO_FROM = "\"\"";
    private static final String ALLOWED_FROM = "^[0-9]+([:,][0-9]+)*$";
    private static final String CUSTOM_FROM = "//\\D\\\\n([0-9]+(\\D[0-9]+)*)";

    public boolean isZeroFrom(final String inputString) {
        return inputString.matches(ZERO_FROM);
    }

    public boolean isAllowedFrom(final String inputString) {
        return inputString.matches(ALLOWED_FROM);
    }

    public boolean isCustomFrom(final String inputString) {
        return inputString.matches(CUSTOM_FROM);
    }

    public void validate(final String inputString) {
        if (isZeroFrom(inputString)) {
            return;
        }
        if (isAllowedFrom(inputString)) {
            return;
        }
        if (isCustomFrom(inputString)) {
            return;
        }
        throw new IllegalArgumentException(inputString + "는 잘못된 입력 양식입니다. ");
    }


}
