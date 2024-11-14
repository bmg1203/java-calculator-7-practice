package calculator.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    void 정상_경우_테스트() {
        //given
        List<String> numberStr = new ArrayList<>();
        numberStr.add("1");
        numberStr.add("2");
        numberStr.add("3");

        //when
        List<Integer> numbers = NumberValidator.validateNumbers(numberStr);

        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.contains(1) && numbers.contains(2) && numbers.contains(3))
                .isTrue();
    }

    @Test
    void 정상_경우_테스트2() {
        //given
        List<String> numberStr = new ArrayList<>();
        numberStr.add("-1");
        numberStr.add("2");
        numberStr.add("3");

        //when
        List<Integer> numbers = NumberValidator.validateNumbers(numberStr);

        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.contains(-1) && numbers.contains(2) && numbers.contains(3))
                .isTrue();
    }

    @Test
    void 예외_경우_테스트() {
        //given
        List<String> numberStr = new ArrayList<>();
        numberStr.add(",1");
        numberStr.add("2");
        numberStr.add("3");

        //when, then
        assertThatThrownBy(() -> NumberValidator.validateNumbers(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_경우_테스트2() {
        //given
        List<String> numberStr = new ArrayList<>();
        numberStr.add("1");
        numberStr.add(";2");
        numberStr.add("3");

        //when, then
        assertThatThrownBy(() -> NumberValidator.validateNumbers(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}