package calculator;

import static calculator.FormatValidator.DECIMAL_ZERO;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void 숫자들의_총합_구하기() {
        long sum = calculator.sum(List.of(1, 2, 3, 4, 5));

        assertThat(sum).isEqualTo(15);
    }

    @Test
    void 전달받은_숫자가_없으면_0_반환() {
        long sum = calculator.sum(List.of());

        assertThat(sum).isEqualTo(DECIMAL_ZERO);
    }
}