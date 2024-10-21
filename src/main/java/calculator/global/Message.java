package calculator.global;

public enum Message {

    INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_MESSAGE("결과 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}