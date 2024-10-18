package calculator;

import java.util.List;

import static calculator.Extractor.extractDelimiter;
import static calculator.Extractor.extractNumberPart;

public class Validator {
    private static final String ERROR_INVALID_DELIMITER = "커스텀 구분자로 숫자 또는 공백을 사용할 수 없습니다.";
    private static final String ERROR_INVALID_FORMAT = "커스텀 구분자 형식이 올바르지 않습니다.";
    private static final String ERROR_DELIMITER_TYPE = "커스텀 구분자는 영어,숫자,공백을 허용하지 않습니다.: ";
    private static final String ERROR_NUMBER_TYPE = "잘못된 숫자 형식입니다: ";
    private static final String ERROR_DELIMITER_DUPLICATE = "중복된 구분자는 허용하지 않습니다.";
    private static final String INVALID_CUSTOM_DELIMITER_PATTERN = "//[\\d\\s]*((\\\\n)|(\\n)).*";

    private final String defaultDelimiter;
    private final String prefix;
    private final String suffix;

    public Validator(String defaultDelimiter, String prefix, String suffix) {
        this.defaultDelimiter = defaultDelimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public void validateDelimiter(String value){
        validateCustomDelimiterFormat(value);
        String delimiter = extractDelimiter(value, defaultDelimiter, prefix, suffix);
        String numberPart = extractNumberPart(value, prefix, suffix);
        validateDelimiterType(numberPart, delimiter);
        validateDuplicateDelimiter(delimiter);
        validateNumberPart(numberPart, delimiter);
    }

    private void validateNumberPart(String numberPart, String delimiter) {
        List<String> numbers = List.of(numberPart.split(delimiter));
        for (String number : numbers) {
            validateNumberFormat(number);
        }
    }

    private static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE + number);
        }
    }

    private void validateCustomDelimiterFormat(String value){
        if(Character.isDigit(value.charAt(0))){
            return;
        }
        if (!value.startsWith(prefix) || !value.contains(suffix)) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
        if (value.matches(INVALID_CUSTOM_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER);
        }
    }

    private void validateDelimiterType(String value, String delimiter){
        if (!value.trim().isEmpty() && delimiter.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException(ERROR_DELIMITER_TYPE + value);
        }
    }

    private void validateDuplicateDelimiter(String delimiter) {
        long distinctCount = delimiter.chars().distinct().count();
        if (distinctCount < delimiter.length()) {
            throw new IllegalArgumentException(ERROR_DELIMITER_DUPLICATE + delimiter);
        }
    }
}
