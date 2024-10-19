package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.Model.InputProcessor;
import org.junit.jupiter.api.Test;

public class InputProcessorTest {
    static final InputProcessor processor = new InputProcessor();

    @Test
    void 기본_구분자_추출() {
        assertSimpleTest(() -> {
            assertThat(processor.getSeparator("1,2:3")).isEqualTo(new String[]{",", ":"});
        });
    }

    @Test
    void 커스텀_구분자_추출() {
        assertSimpleTest(() -> {
            assertThat(processor.getSeparator("//*\\n1*2*3")).isEqualTo(new String[]{"*"});
        });
    }

    @Test
    void 커스텀_구분자_추출_예외_1() {
        assertThatThrownBy(() -> {
            processor.getSeparator("//1+2+3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 올바르게 정의되지 않았습니다.");
    }

    @Test
    void 커스텀_구분자_추출_예외_2() {
        assertThatThrownBy(() -> {
            processor.getSeparator("1+\\n2+3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 올바르게 정의되지 않았습니다.");
    }

    @Test
    void 숫자_배열_출력_기본_구분자() {
        assertSimpleTest(() -> {
            assertThat(processor.processInput("1,2:3")).isEqualTo(new long[]{1, 2, 3});
        });
    }

    @Test
    void 숫자_배열_출력_커스텀_구분자() {
        assertSimpleTest(() -> {
            assertThat(processor.processInput("//*\\n1*2*3")).isEqualTo(new long[]{1, 2, 3});
        });
    }

    @Test
    void 숫자_배열_출력_커스텀_구분자_2() {
        assertSimpleTest(() -> {
            assertThat(processor.processInput("//*$\\n1*$2*$3")).isEqualTo(new long[]{1, 2, 3});
        });
    }

    @Test
    void 숫자_배열_출력_커스텀_구분자_빈문자() {
        assertSimpleTest(() -> {
            assertThat(processor.processInput("//&\\n1&&2&3")).isEqualTo(new long[]{1, 0, 2, 3});
        });
    }

    @Test
    void 숫자_배열_출력_커스텀_구분자_기호() {
        assertThatThrownBy(() -> {
            processor.processInput("//&\\n1&(2&3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다: (2");
    }

    @Test
    void 숫자_배열_출력_커스텀_구분자_음수() {
        assertThatThrownBy(() -> {
            processor.processInput("//&\\n1&-2&3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 값이 포함되어 있습니다: -2");
    }

    @Test
    void 숫자_배열_출력_빈_커스텀_구분자() {
        assertSimpleTest(() -> {
            assertThat(processor.processInput("//\\n123")).isEqualTo(new long[]{1, 2, 3});
        });
    }
}
