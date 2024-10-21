package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SplitServiceTest {

    @DisplayName("기본 구분자 분할 확인")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("basicSplit")
    void basicDelimiterSplit(String input, String expected) {
        SplitService splitService = new SplitService();
        List<String> numbers = splitService.split(input);
        assertEquals(expected, numbers.toString());
    }

    static Stream<Arguments> basicSplit() {
        return Stream.of(
                Arguments.of("3,4,5", "[3, 4, 5]"),
                Arguments.of("3:4:5", "[3, 4, 5]"),
                Arguments.of("3,4:5", "[3, 4, 5]"),
                Arguments.of("3", "[3]")
        );
    }

    @DisplayName("커스텀 구분자 분할 확인")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("customSplit")
    void CustomDelimiterSplit(String input, String expected) {
        SplitService splitService = new SplitService();
        List<String> numbers = splitService.split(input);
        assertEquals(expected, numbers.toString());
    }

    static Stream<Arguments> customSplit() {
        return Stream.of(
                Arguments.of("//;\\n3;4;5", "[3, 4, 5]"),
                Arguments.of("//;\\n3;4,5", "[3, 4, 5]"),
                Arguments.of("// \\n3 4 5", "[3, 4, 5]"),
                Arguments.of("//\\s\\n3 4 5", "[3, 4, 5]"),
                Arguments.of("//and\\n3and4and5", "[3, 4, 5]"),
                Arguments.of("//;\\n3", "[3]")
        );
    }

    @DisplayName("커스텀 구분자 입력 비어있을시 예외")
    @Test
    void checkInvalidDelimiter() {
        SplitService splitService = new SplitService();
        assertThrows(IllegalArgumentException.class, () -> splitService.split("//\\n3;4;5"));
    }

    @DisplayName("덧셈 할 문자열 비어있을시 예외")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("invalidExpression")
    void checkInvalidExpression(String input) {
        SplitService splitService = new SplitService();
        assertThrows(IllegalArgumentException.class, () -> splitService.split(input));
    }

    static Stream<Arguments> invalidExpression() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("//;\\n")
        );
    }
}