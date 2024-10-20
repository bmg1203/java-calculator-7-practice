package calculator.constant;

public enum ExceptionMessage {

    NOT_INTEGER("숫자를 입력해주세요."),
    NOT_POSITIVE("양수만 입력할 수 있습니다."),
    NUMBER_WITH_SEPARATOR("숫자는 구분자로 사용할 수 없습니다."),
    INVALID_INPUT("올바른 입력 형식이 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
