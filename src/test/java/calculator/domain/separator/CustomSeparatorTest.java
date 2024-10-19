package calculator.domain.separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.domain.number.Number;
import calculator.domain.number.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomSeparatorTest {

    CustomSeparator customSeparator;

    @BeforeEach
    void init() {
        customSeparator = new CustomSeparator(";");
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\\n1;2;3")
    void 커스텀구분자(String value) {
        Numbers numbers = customSeparator.separate(value);

        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\\n1.2;2.3;3.3")
    void 커스텀구분자실수(String value) {
        Numbers numbers = customSeparator.separate(value);

        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n;1;2", "//;\\n1;2;", "//;\\n;1;"})
    void 양사이드구분자예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;;2", "//;\\n;;1", "//;\\n1;;"})
    void 연속커스텀구분자예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\\n1;a;2")
    void 문자포함예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\\n")
    void 커스텀구분자빈문자열(String value) {
        Numbers numbers = customSeparator.separate(value);
        Number number = numbers.getNumbers().getFirst();

        assertThat(numbers.getNumbers().size()).isEqualTo(1);
        assertThat(number.getValue()).isEqualTo(0);
    }
}