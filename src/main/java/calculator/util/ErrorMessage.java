package calculator.util;

public interface ErrorMessage {
    String INVALID_POSITIVE_NUMBER = "[ERROR] 양수만 입력해주세요";
    String INVALID_DIGIT = "[ERROR] 숫자만 입력해주세요";
    String INVALID_CUSTOM_DELIMITER_FORMAT = "[ERROR] 커스텀 구분자형식에 맞춰서 입력해주세요.";
    String INVALID_FORMAT = "[ERROR] 형식에 맞춰서 입력해주세요";
    String DUPLICATE_DELIMITER = "[ERROR] 이미 추가한 구분자는 custom으로 지정할 수 없습니다.";
}
