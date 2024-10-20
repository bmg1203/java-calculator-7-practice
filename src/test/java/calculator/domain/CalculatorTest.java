package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculatorTest {

    @Test
    @DisplayName("계산기는 숫자들을 가진다")
    void 계산기_숫자_가짐_TEST(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(1.0, 1.1, 2.0));

        Calculator calculator = new Calculator(numbers);

        Assertions.assertThat(calculator.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("숫자는 양수로 이루어져 있다")
    void 숫자_양수_TEST(){
        List<Double> invalidNumbers1 = new ArrayList<>(Arrays.asList(0.0, 1.1, 2.0));
        List<Double> invalidNumbers2 = new ArrayList<>(Arrays.asList(-1.0, 1.1, 2.0));

        Assertions.assertThatThrownBy(() -> new Calculator(invalidNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 양수만 가능합니다.");

        Assertions.assertThatThrownBy(() -> new Calculator(invalidNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 양수만 가능합니다.");

    }

    @Test
    @DisplayName("숫자의 합을 반환한다")
    void 숫자_합_반환(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(1.0, 1.1, 2.0));

        Calculator calculator = new Calculator(numbers);

        Assertions.assertThat(calculator.getSum()).isEqualTo(4.1);
    }

    @Test
    @DisplayName("숫자가 정수로만 이루어져 있으면 정수값을 반환한다")
    void 숫자_합_정수_반환(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(1.0, 3.0, 2.0));

        Calculator calculator = new Calculator(numbers);

        Assertions.assertThat(calculator.getSum()).isEqualTo(6L);
        Assertions.assertThat(calculator.getSum()).isNotEqualTo(6.0);
    }

}