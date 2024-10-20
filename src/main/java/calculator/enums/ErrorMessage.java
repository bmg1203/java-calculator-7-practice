package calculator.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("입력 문자열은 공백으로만 구성될 수 없습니다."),
    FIRST_CHAR_CANNOT_BE_SPACE("입력 문자열의 첫 문자는 공백일 수 없습니다."),
    LAST_CHAR_CANNOT_BE_SPACE("입력 문자열의 마지막 문자는 공백일 수 없습니다."),
    CUSTOM_DELIMITER_NOT_FOUND("\"//\"'와 \"\\n\" 사이에 구분자가 입력되지 않았습니다."),
    CUSTOM_DELIMITER_CANNOT_CONTAIN_NUMERIC("커스텀 구분자에는 숫자가 포함될 수 없습니다."),
    CUSTOM_DELIMITER_MUST_BE_IN_FRONT("커스텀 구분자는 문자열 앞쪽에 위치해야 합니다."),
    INVALID_CHAR_INCLUDED("구분자가 아닌 문자가 포함되어 있습니다."),
    DELIMITER_MUST_BE_BETWEEN_NUMBERS("구분자는 숫자 사이에 위치해야 합니다."),
    NUMBER_TOO_LARGE("숫자가 너무 큽니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
