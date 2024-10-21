package calculator.service.exception;

import calculator.exception.ExceptionType;

public enum SeparationExceptionType implements ExceptionType {

    // SeparationService
    STARTS_WITH_SEPARATOR("입력값이 구분자로 시작합니다."),
    ENDS_WITH_SEPARATOR("입력값이 구분자로 끝납니다."),
    INVALID_SEPARATOR("유효한 구분자가 아닙니다."),
    NOT_A_POSITIVE_NUMBER("양수가 아닙니다."),
    // CustomSeparationService
    NOT_EXIST_CUSTOM_SEPARATOR("커스텀 구분자가 존재하지 않습니다."),
    ;

    private final String message;

    SeparationExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
