package calculator.constants;

public final class Constants {

    private Constants() {
    }

    public static final CharSequence COMMA = ",";
    public static final CharSequence COLON = ":";
    public static final String BASIC_DELIMITER = COMMA + "|" + COLON;
    public static final String WRONG_DELIMITER = "잘못된 구분자입니다";
    public static final String INVALID_CUSTOM_FORMAT = "올바르지 않은 커스텀 구분자 형식입니다";
    public static final String NOT_CONTAINS_NUMBER = "숫자와 함께 입력해주세요";
    public static final String CONTAINS_NEGATIVE = "문자열에 음수가 포함되어있습니다";
}
