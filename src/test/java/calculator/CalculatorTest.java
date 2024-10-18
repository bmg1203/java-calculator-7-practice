package calculator;

import calculator.delimiter.filter.NegativeNumberValidationFilter;
import calculator.delimiter.filter.ValidationFilter;
import calculator.delimiter.handler.factory.DelimiterHandlerFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {
    private DelimiterHandlerFactory factory = new DelimiterHandlerFactory();
    private ValidationFilter middleware = ValidationFilter.link(
            new NegativeNumberValidationFilter()
    );
    private Calculator calculator = new Calculator(factory, middleware);

    @Test
    @DisplayName("문자열을 받아 계산값을 반환한다.")
    void calculate_sum_with_string() {
        String s = "1,2:3,4";

        int sum = calculator.sum(s);

        Assertions.assertThat(sum).isEqualTo(10);
    }
}
