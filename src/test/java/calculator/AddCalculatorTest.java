package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AddCalculatorTest {

    @Test
    void 숫자_두_개를_더할_수_있다() {
        double a = 1;
        double b = 3;

        AddCalculator.add(a, b);

        assertEquals(4, AddCalculator.sum());
    }

    @Test
    void 숫자가_한_개면_해당_숫자를_결과_값으로_반환한다() {
        double number = 1;
        double result = AddCalculator.add(number);

        assertEquals(1, result);
    }
}
