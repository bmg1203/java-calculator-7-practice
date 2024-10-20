package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import calculator.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Nested
    @DisplayName("validate 메서드는")
    class ValidateMethod {

        @Test
        @DisplayName("빈 문자열인 경우 예외를 발생시키지 않는다")
        void 빈_문자열인_경우_예외를_발생시키지_않는다() {
            // given
            String emptyInput = "";

            // when & then
            assertThatNoException().isThrownBy(() -> InputValidator.validate(emptyInput));
        }

        @Test
        @DisplayName("공백 문자열인 경우 예외를 발생시킨다")
        void 공백_문자열인_경우_예외를_발생시킨다() {
            // given
            String blankInput = " ";

            // when & then
            assertThatThrownBy(() -> InputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("입력 문자열의 첫 번째 문자가 공백인 경우 예외를 발생시킨다")
        void 입력_문자열의_첫_번째_문자가_공백인_경우_예외를_발생시킨다() {
            // given
            String input = " 4,2";

            // when & then
            assertThatThrownBy(() -> InputValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.FIRST_CHAR_CANNOT_BE_SPACE.getMessage());
        }

        @Test
        @DisplayName("입력 문자열의 마지막 문자가 공백인 경우 예외를 발생시킨다")
        void 입력_문자열의_마지막_문자가_공백인_경우_예외를_발생시킨다() {
            // given
            String input = "1:2 ";

            // when & then
            assertThatThrownBy(() -> InputValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LAST_CHAR_CANNOT_BE_SPACE.getMessage());
        }

        @Test
        @DisplayName("올바른 입력 문자열인 경우 예외를 발생시키지 않는다")
        void 올바른_입력_문자열인_경우_예외를_발생시키지_않는다() {
            // given
            String validInput = "1,2:3";

            // when & then
            assertThatNoException().isThrownBy(() -> InputValidator.validate(validInput));
        }
    }
}