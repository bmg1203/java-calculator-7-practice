package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.INVALID_VALUE_FORMAT;
import static calculator.domain.constant.errorMessage.ValueError.MINUS_VALUE;
import static calculator.domain.constant.errorMessage.ValueError.OUT_OF_RANGE_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("입력값이 공백이면 0을 반환한다")
    void returnsZeroForEmptyInput() {
        Parser parser = new Parser();
        String input = "";

        List<Integer> result = parser.parseInput(input);
        assertEquals(List.of(0), result);
    }

    @Test
    @DisplayName("숫자 사이에 공백이 있으면 예외를 발생시킨다")
    void throwsExceptionForWhitespaceInNumbers() {
        Parser parser = new Parser();
        String input = "1 2,3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput(input));
        assertEquals(INVALID_VALUE_FORMAT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("음수 값이 있으면 예외를 발생시킨다")
    void throwsExceptionForNegativeNumbers() {
        Parser parser = new Parser();
        String input = "1,-2,3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput(input));
        assertEquals(MINUS_VALUE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("int 범위를 넘는 값이 있으면 예외를 발생시킨다")
    void throwsExceptionForOutOfRangeValues() {
        Parser parser = new Parser();
        String input = "1,2147483648";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput(input));
        assertEquals(OUT_OF_RANGE_VALUE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구분자가 공백인 경우 정상출력")
    void parsesCorrectlyForValidInput() {
        Parser parser = new Parser();
        String input = "// \\n1 2 3";

        List<Integer> result = parser.parseInput(input);
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    @DisplayName("추출한 값이 정수인 경우 정상 출력되고, 모든 값이 Integer 타입인지 확인한다")
    void parsesCorrectlyIntegerValue() {
        Parser parser = new Parser();
        String input = "// \\n1 2 3";

        List<Integer> result = parser.parseInput(input);

        result.forEach(value -> assertInstanceOf(Integer.class, value));

        assertEquals(List.of(1, 2, 3), result);
    }


}
