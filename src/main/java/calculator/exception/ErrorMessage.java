package calculator.exception;

public enum ErrorMessage {

    NOT_MATCH_FOUND_DELIMITER("매칭되는 구분자가 없습니다."),
    INVALID_INPUT("구분자와 숫자를 정확하게 입력해주세요."),
    NEGATIVE_NUMBER_NOT_ALLOWED("음수는 입력할 수 없습니다."),
    CUSTOM_DELIMITER_CANNOT_BE_NUMBER("커스텀 문자에 숫자를 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}