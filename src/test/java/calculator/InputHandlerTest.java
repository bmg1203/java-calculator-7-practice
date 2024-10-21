package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    @Test
    void 기본_구분자_추출_테스트() {
        InputHandler inputHandler = new InputHandler();
        String input = "1,2:3";
        String delimiters = inputHandler.getDelimiters(input);
        assertThat(delimiters).isEqualTo(",|:");
    }

    @Test
    void 잘못된_구분자_예외_테스트() {
        InputHandler inputHandler = new InputHandler();
        String input = "//;\n1;2";
        assertThatThrownBy(() -> inputHandler.getDelimiters(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구분자가 잘못 설정되었습니다.");
    }

    @Test
    void 숫자_구분자_예외_테스트() {
        InputHandler inputHandler = new InputHandler();
        String input = "//1\\n1,2,3";
        assertThatThrownBy(() -> inputHandler.getDelimiters(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구분자는 숫자가 될 수 없습니다.");
    }

    @Test
    void 여러_글자_구분자_예외_테스트() {
        InputHandler inputHandler = new InputHandler();
        String input = "//abc\\n1,2,3";
        assertThatThrownBy(() -> inputHandler.getDelimiters(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구분자는 반드시 한 글자여야 합니다.");
    }

    @Test
    void 커스텀_구분자와_기본_구분자_혼합_사용_테스트() {
        InputHandler inputHandler = new InputHandler();
        String input = "//;\\n1;2,3:4";

        String delimiters = inputHandler.getDelimiters(input);

        assertThat(delimiters).isEqualTo(";|,|:");
    }

    @Test
    void 커스텀_구분자와_기본_구분자_문자열_분리_테스트() {
        InputHandler inputHandler = new InputHandler();
        StringSplitter splitter = new StringSplitter();
        String input = "//;\\n1;2,3:4";

        String delimiters = inputHandler.getDelimiters(input);
        String processedInput = inputHandler.getProcessedInput(input);

        String[] result = splitter.split(processedInput, delimiters);

        assertThat(result).containsExactly("1", "2", "3", "4");
    }

    @Test
    void 기본_구분자_빈_문자열_테스트() {
        String input = "";
        assertThat(input).isEqualTo("");
        assertThat("0").isEqualTo("0");
    }

    @Test
    void 커스텀_구분자_빈_문자열_테스트() {
        String input = "//n\n";
        assertThat(input).isEqualTo("//n\n");
        assertThat("0").isEqualTo("0");
    }
}
