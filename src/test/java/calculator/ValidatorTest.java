package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 기본_구분자_검증_테스트() {
        // Given : 기본 구분자가 적용된 가상의 입력
        String input = "1:2,3";

        // When & Then : Validator 실행 시 예외가 발생하지 않으면 성공
        Validator validator = new Validator();
        assertDoesNotThrow(() -> validator.validateInput(input));
    }

    @Test
    void 커스텀_구분자_검증_테스트() {
        // Given: 커스텀 구분자가 적용된 가상의 입력
        String input = "//*\n1*2*3";

        // When & Then : Validator 실행 시 예외가 발생하지 않으면 성공
        Validator validator = new Validator();
        assertDoesNotThrow(() -> validator.validateInput(input));
    }
}
