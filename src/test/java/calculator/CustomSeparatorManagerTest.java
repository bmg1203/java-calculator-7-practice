package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CustomSeparatorManagerTest {

    @ParameterizedTest
    @DisplayName("//로 시작하고 \\n으로 끝나는 문자열 안에 커스텀 구분자가 있는지 확인한다")
    @MethodSource("generateCustomSeparatorStringData")
    void testHasCustomSeparator(String inputString, boolean expected) {
        assertThat(CustomSeparatorManager.hasCustomSeparator(inputString)).isEqualTo(expected);
    }

    static Stream<Arguments> generateCustomSeparatorStringData() {
        return Stream.of(
                Arguments.of("//d\\n", true),
                Arguments.of("//\\n", false),
                Arguments.of("/\\n", false),
                Arguments.of("d\\n", false),
                Arguments.of("//d", false),
                Arguments.of("//customSeparator\\n", true),
                Arguments.of("// \\n", false),
                Arguments.of("a//d\\n", false)
        );
    }

    @ParameterizedTest
    @DisplayName("//와 \\n 사이의 커스텀 구분자를 반환하는지 확인")
    @MethodSource("generateValidCustomSeparatorData")
    void testGetCustomSeparator(String inputString, Separator expectedCustomSeparator) {
        Separator actualSeparator = CustomSeparatorManager.getCustomSeparator(inputString);
        assertThat(actualSeparator).isEqualTo(expectedCustomSeparator);
    }

    static Stream<Arguments> generateValidCustomSeparatorData() {
        return Stream.of(
                Arguments.of("//d\\n", new Separator("d")),
                Arguments.of("//customSeparator\\n", new Separator("customSeparator"))
        );
    }
}