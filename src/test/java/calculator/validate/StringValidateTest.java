package calculator.validate;

import static calculator.validate.StringValidate.isInputStartWithSlash;
import static calculator.validate.StringValidate.validateBackString;
import static calculator.validate.StringValidate.validateNewLineInput;
import static calculator.validate.StringValidate.validateNotNullInput;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValidateTest {
    @Test
    @DisplayName("null 입력 테스트")
    void inputWithNull() {
        assertThrows(IllegalArgumentException.class, () -> validateNotNullInput(null));
    }

    @Test
    @DisplayName("'//'로 시작하는 문자열 테스트")
    void startWithSlash() {
        String input = "//abc";

        assertTrue(isInputStartWithSlash(input));
    }

    @Test
    @DisplayName("'//'로 시작하지 않는 문자열 테스트")
    void startWithoutSlash() {
        String input = "abc//";

        Assertions.assertFalse(isInputStartWithSlash(input));
    }

    @Test
    @DisplayName("'\n'이 없는 문자열 테스트")
    void inputWithoutEndLine() {
        String input = "//test";

        assertThrows(IllegalArgumentException.class, () -> validateNewLineInput(input));
    }

    @Test
    @DisplayName("계산해야 하는 문자열에 숫자, 구분자 외 다른 문자가 있으면 IllegalArgumentException가 발생한다.")
    void otherCharInBackString() {
        String string = "1a2B3c";
        String separator = "abc";

        assertThrows(IllegalArgumentException.class, () -> validateBackString(string, separator));
    }

    @Test
    @DisplayName("계산해야 하는 문자열에 숫자만 있는 경우")
    void onlyNumberInBackString() {
        String string = "123456";
        String separator = "abc";

        assertTrue(validateBackString(string, separator));
    }

    @Test
    @DisplayName("계산해야 하는 문자열에 구분자만 있는 경우")
    void onlySeparatorInBackString() {
        String string = "abcabc";
        String separator = "abc";

        assertTrue(validateBackString(string, separator));
    }

    @Test
    @DisplayName("계산해야 하는 문자열이 빈 문자열인 경우")
    void emptyBackString() {
        String string = "";
        String separator = "abc";

        assertTrue(validateBackString(string, separator));
    }

    @Test
    @DisplayName("구분자가 없는 경우")
    void emptySeparator() {
        String string = "1234";
        String separator = "";

        assertTrue(validateBackString(string, separator));
    }
}