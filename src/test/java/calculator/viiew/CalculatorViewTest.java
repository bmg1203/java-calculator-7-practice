package calculator.viiew;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorViewTest {

    @DisplayName("입력 테스트")
    @Test
    void input() {
        String input = "1,2,3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CalculatorView view = new CalculatorView();
        String result = view.input();

        assertThat(result).isEqualTo(input);
        assertThat(result).isNotEqualTo("1,2,3,4");
    }

    @DisplayName("출력 테스트")
    @Test
    void resultOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CalculatorView view = new CalculatorView();
        view.resultOutput(10);

        String expectedOutput = "결과 : 10" + System.lineSeparator();
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
        assertThat(outputStream.toString()).isNotEqualTo("결과 : 0" + System.lineSeparator());
    }

}