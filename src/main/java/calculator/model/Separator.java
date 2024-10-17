package calculator.model;

import static calculator.common.constant.Constants.SEPARATOR_SIZE;
import static calculator.common.exception.ErrorMessage.SEPARATOR_FORMAT_ERROR;

public record Separator(String separator) {

    public static Separator from(String separator) {
        return new Separator(Validator.validate(separator));
    }

    private static class Validator {
        private static String validate(String separator) {
            validateLength(separator);
            return separator;
        }

        private static void validateLength(String separator) {
            if (separator.length() != SEPARATOR_SIZE) {
                throw new IllegalArgumentException(SEPARATOR_FORMAT_ERROR);
            }
        }
    }
}
