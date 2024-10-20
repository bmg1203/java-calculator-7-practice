package calculator.caulculatorApplication.domain.common;

public enum PositiveNumberExceptionMessageTest {

    NO_EMPTY("입력 리스트는 null이거나 비어있을 수 없습니다."),
    NO_NEGATIVE("음수는 허용되지 않습니다: ");

    private final String message;

    PositiveNumberExceptionMessageTest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
