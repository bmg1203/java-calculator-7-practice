package calculator.domain.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BasicInputTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void 생성(String input) {
        assertThat(BasicDelimiterInput.from(input)).isEqualTo(BasicDelimiterInput.from(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void long_배열_생성(String input) {
        assertThat(BasicDelimiterInput.from(input).createCalculationInputs())
                .containsExactly(1L, 2L, 3L);
    }
}
