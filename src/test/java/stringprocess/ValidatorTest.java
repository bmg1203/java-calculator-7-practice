package stringprocess;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.Constant;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final Validator validator = new Validator(Constant.CUSTOM_SEPARATOR_END_STR_TEST);

    @Test
    void 문자열_유효성_검사_성공() {
        //given
        String[] input = {"//*\n1,2:3*4", "//*\n", "1,2,3:4", "1,2,3:4//*\n", "//;\n2;3;4"};

        //then
        for (String str : input) {
            assertDoesNotThrow(() -> validator.validate(str));
        }

    }

    @Test
    void 문자열의_시작과_끝_검사_실패() {
        //given
        String[] input1 = {",3,4:5", "3,4:5:", "3:4//;\\n;6;"};
        String[] input2 = {"3:4//;\\n;6;", "3,4:5:"};

        //then
        for (String str : input1) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    "문자열의 시작은 커스텀 구분자 선언 또는 양수여야 합니다");
        }

        for (String str : input2) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    "문자열의 끝은 커스텀 구분자 종료 선언 또는 양수여야 합니다.");
        }
    }

    @Test
    void 문자열의_시작과_끝_마지막수가0() {
        //given
        String[] input = {"1,12:3://*\n4*50*6*0", "1,12:3://*\n4*50*6*00", "1,12:3://*\n4*50*6*000"};

        //then
        for (String str : input) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    "문자열의 끝은 커스텀 구분자 종료 선언 또는 양수여야 합니다.");
        }
    }

    @Test
    void 문자열의_시작과_끝_마지막_양수가_0으로끝나는_두자리수이상인_양수인경우() {
        //given
        String input = "1,12:3://*\n4*50*6*300";

        //then
        assertDoesNotThrow(() -> validator.validate(input));
    }

    @Test
    void 커스텀_구분자_형식_유효성_검사하기_실패() {
        //given
        String[] input = {"//*\1,2:3*4", "/*\n1,2:3*4", "//*n1,2:3*4", "//*1,2:3*4"};

        //then
        for (String str : input) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    "커스텀 구분자 형식이 올바르지 않습니다.");
        }

    }

}