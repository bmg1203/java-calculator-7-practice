package calculator;

import calculator.dto.CalculatorResultResponse;
import calculator.dto.NumberRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorModelTest {
    CalculatorModel calculatorModel = new CalculatorModel();

    @Test
    void 구분자_나누기_테스트() {
        String[] inputs = {"1,2,3", "1,2:3", "1:2:3"};
        String[][] expectedOutputs = {
                {"1", "2", "3"},
                {"1", "2", "3"},
                {"1", "2", "3"}
        };

        for (int i = 0; i < inputs.length; i++) {
            String[] result = inputs[i].split("[,:]");

            assertThat(result)
                    .as("Input: %s", inputs[i])
                    .containsExactly(expectedOutputs[i]);
        }
    }

    @Test
    void 커스텀_구분자_합_테스트() {
        NumberRequest request = new NumberRequest("//;\\n1;2;3");
        CalculatorResultResponse result = calculatorModel.calculateSum(request);

        assertThat(result.sumResult()).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_합_예외_테스트1() {
        NumberRequest request = new NumberRequest("//\n\n1;2;3");

        assertThatThrownBy(() -> calculatorModel.calculateSum(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_합_예외_테스트2() {
        NumberRequest request = new NumberRequest("//2\n1;2;3");

        assertThatThrownBy(() -> calculatorModel.calculateSum(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_합_예외_테스트3() {
        NumberRequest request = new NumberRequest("//\n3\n1;2;3");

        assertThatThrownBy(() -> calculatorModel.calculateSum(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 콤마_합_테스트() {
        NumberRequest request = new NumberRequest("1,2,3");
        CalculatorResultResponse result = calculatorModel.calculateSum(request);

        assertThat(result.sumResult()).isEqualTo(6);
    }

    @Test
    void 콜론_합_테스트() {
        NumberRequest request = new NumberRequest("1:2:5");
        CalculatorResultResponse result = calculatorModel.calculateSum(request);

        assertThat(result.sumResult()).isEqualTo(8);
    }

    @Test
    void 구분자_사용_합_테스트() {
        NumberRequest request = new NumberRequest("1,2:3");
        CalculatorResultResponse result = calculatorModel.calculateSum(request);

        assertThat(result.sumResult()).isEqualTo(6);
    }

    @Test
    void 허용_외_문자열_입력_예외_테스트() {
        NumberRequest request = new NumberRequest("1;2:3");

        assertThatThrownBy(() -> calculatorModel.calculateSum(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null_입력_예외_테스트() {
        NumberRequest request = new NumberRequest(null);

        assertThatThrownBy(() -> calculatorModel.calculateSum(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_입력_0반환_테스트() {
        NumberRequest request = new NumberRequest("");

        CalculatorResultResponse result = calculatorModel.calculateSum(request);

        assertThat(result.sumResult()).isEqualTo(0);
    }

    @Test
    void 빈_공백입력_0반환_테스트() {
        NumberRequest request = new NumberRequest("    ");

        CalculatorResultResponse result = calculatorModel.calculateSum(request);

        assertThat(result.sumResult()).isEqualTo(0);
    }
}
