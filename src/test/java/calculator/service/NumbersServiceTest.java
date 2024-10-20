package calculator.service;

import calculator.model.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("NumbersService 테스트")
class NumbersServiceTest {
    private NumbersService numbersService;

    @BeforeEach
    void setUp() {
        numbersService = new NumbersService();
    } // setUp

    @Test
    @DisplayName("구분자로 구분 후 Numbers 객체 생성 확인")
    void testCreateNumbersWithSeparators() {
        assertThat(numbersService.createNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))).isInstanceOf(Numbers.class);
    } // testCreateNumbersWithSeparators

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("구분자가 없을 때 Numbers 객체 생성 확인")
    @MethodSource("generateDataNotContainsSeparators")
    void testCreateNumbersNotWithSeparators(String input, Class output, String message) {
        assertThat(numbersService.createNumbers(input)).isInstanceOf(output);
    } // testCreateNumbersNotWithSeparators

    private static Stream<Arguments> generateDataNotContainsSeparators() {
        return Stream.of(
                Arguments.of(null, Numbers.class, "null 입력"),
                Arguments.of("", Numbers.class, "공백 입력"),
                Arguments.of(" ", Numbers.class, "white space 입력"),
                Arguments.of("1", Numbers.class, "숫자 1만 입력"),
                Arguments.of("2000000000", Numbers.class, "숫자 20억 입력")
        );
    } // generateData

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("구분자가 있을 때 Numbers 객체 생성 예외 확인")
    @MethodSource("generateExceptionDataWithSeparators")
    void inputExceptionTest(String input, String message) {
        assertThatThrownBy(() -> numbersService.createNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    } // inputExceptionTest

    private static Stream<Arguments> generateExceptionDataWithSeparators() {
        return Stream.of(
                Arguments.of(";123", "숫자만으로 구성되지 않았을 때"),
                Arguments.of("-2", "음수일 때"),
                Arguments.of("20000000001", "20억 초과일 때")
        );
    } // generateExceptionData

    @Test
    @DisplayName("구분자가 없을 때 Numbers 객체 생성 예외 확인 - 10개 초과")
    void inputExceptionTest() {
        assertThatThrownBy(() -> numbersService.createNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    } // inputExceptionTest
} // class