package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

    @DisplayName("숫자는 양수이어야 한다")
    @ParameterizedTest
    @MethodSource("negativeOrZeroNumbers")
    void isPositiveNumber(List<Long> invalidData) {
        assertThatThrownBy(() -> Numbers.from(invalidData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBERS_MUST_POSITIVE.getMessage());
    }

    @DisplayName("숫자의 합을 계산할 수 있다")
    @ParameterizedTest
    @MethodSource("numbersAndCorrectResult")
    void sum(List<Long> validData, Long correctResult) {
        Numbers numbers = Numbers.from(validData);
        assertThat(numbers.sum()).isEqualTo(correctResult);
    }

    @DisplayName("숫자는 문자열 배열을 변환할 때 문자열에 문자가 포함되어 있으면 예외를 반환한다")
    @ParameterizedTest
    @MethodSource("stringIncludeCharacter")
    void isNumber(List<String> invalidData) {
        assertThatThrownBy(() -> Numbers.parseNumbers(invalidData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBERS_MUST_NUMBER.getMessage());
    }

    @DisplayName("숫자는 문자열 배열을 변환할 때 표현 범위를 넘어서면 예외를 반환한다")
    @ParameterizedTest
    @MethodSource("stringNumberOverRange")
    void isRangeIn(List<String> invalidData) {
        assertThatThrownBy(() -> Numbers.parseNumbers(invalidData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBERS_RANGE.getMessage());
    }

    static Stream<Arguments> numbersAndCorrectResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1L, 2L, 3L), 6L),
                Arguments.of(Arrays.asList(1000000000L, 2000000000L, 3000000000L), 6000000000L)
        );
    }

    static Stream<Arguments> negativeOrZeroNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1L, 2L, -3L)),
                Arguments.of(Arrays.asList(1L, 0L))
        );
    }

    static Stream<Arguments> stringIncludeCharacter() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "2", "5f5")),
                Arguments.of(Arrays.asList("1", "2", "55", "1!")),
                Arguments.of(Arrays.asList("!", "2", "55", "1")),
                Arguments.of(Arrays.asList("z", "55", "1"))
        );
    }

    static Stream<Arguments> stringNumberOverRange() {
        return Stream.of(
                Arguments.of(List.of("9223372036854775808"))
        );
    }
}