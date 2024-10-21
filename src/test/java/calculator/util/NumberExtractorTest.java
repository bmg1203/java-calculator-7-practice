package calculator.util;

import calculator.exception.util.InputValidateErrorMessage;
import calculator.exception.util.NumberExtractorErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.exception.util.InputValidateErrorMessage.*;
import static calculator.exception.util.NumberExtractorErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberExtractorTest {
    @Test
    @DisplayName("정상적으로 숫자 및 구분자가 포함된 문자열 (커스텀 구분자 x)")
    void 정상적인_숫자가_포함된_문자열_커스텀_구분자_x() {
        // given
        String input = "1,2:3";
        String[] delimiters = {",", ":"};

        // when
        int[] result = NumberExtractor.extract(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("정상적으로 숫자 및 구분자가 포함된 문자열 (커스텀 구분자 o)")
    void 정상적인_숫자가_포함된_문자열_커스텀_구분자_o() {
        // given
        String input = "1&2:6";
        String[] delimiters = {",", ":", "&"};

        // when
        int[] result = NumberExtractor.extract(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 6);
    }

    @Test
    @DisplayName("기본 구분자 또는 커스텀 구분자가 아닌 구분자가 포함된 경우 예외 처리")
    void 지정된_구분자가_아닌_문자열() {
        // given
        String input = "3?4";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("0 또는 음수를 포함된 경우 예외 처리")
    void 음수_또는_0이_포함된_문자열() {
        // given
        String input = "4:-3";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_OR_ZERO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 문자가 포함된 경우 예외 처리")
    void 유효하지_않은_문자가_포함된_문자열() {
        // given
        String input = "4:2,abc";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("분리할 수 없는 문자일 경우 예외 처리")
    void 분리할_수_없는_문자열() {
        // given
        String input = "4:3, ,";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SPLIT.getMessage());
    }

    @Test
    @DisplayName("int 범위를 벗어나는 숫자일 경우 예외 처리")
    void int_범위를_벗어나는_숫자() {
        // given
        String input = "2147483648:4,5";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_INT_RANGE.getMessage());
    }

    @Test
    @DisplayName("정수가 아닌 숫자가 포함된 경우 예외 처리")
    void 정수가_아닌_숫자() {
        // given
        String input = "1.5:3,4";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("기본 구분자가 여러개 들어갈 경우")
    void 기본_구분자_여러개() {
        // given
        String input = "13:::::34:2";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SPLIT.getMessage());
    }
}