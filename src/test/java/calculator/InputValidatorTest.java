package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.delimiter.DefaultDelimiter;
import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import calculator.parser.Parser;
import calculator.validation.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private InputValidator inputValidator;
    private Parser parser;

    @BeforeEach
    void setUp() {
        Delimiter delimiter = new DefaultDelimiter();
        parser = new Parser();
        inputValidator = new InputValidator(delimiter, parser);
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 문자열 입력에 정상 동작")
    void testStartsWithNumber() {
        //given
        String input = "1:2,3";
        //when
        String result = inputValidator.validate(input);
        //then
        assertEquals("6", result);
    }

    @Test
    @DisplayName("커스텀 구분자가 있으면 정상 동작")
    void testStartsWithCustomDelimiter() {
        //given
        String input = "//.\\n1:2,3.4";
        Delimiter delimiter = DelimiterFactory.createDelimiter(input);
        inputValidator = new InputValidator(delimiter, parser);
        //when
        String result = inputValidator.validate(input);
        //then
        assertEquals("10", result);
    }

    @Test
    @DisplayName("빈 문자열 입력시 0 반환")
    void testEmptyString() {
        //given
        String input = "";
        //when
        String result = inputValidator.validate(input);
        //then
        assertEquals("0", result);
    }

    @Test
    @DisplayName("유효하지 않은 입력 시 예외 발생")
    void testInvalidInput() {
        assertThrowsOnInvalidInput("abc,1,2,3");
        assertThrowsOnInvalidInput("-abc,1,2,3");
        assertThrowsOnInvalidInput(".abc,1,2,3");
    }

    private void assertThrowsOnInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validate(input));
    }
}
