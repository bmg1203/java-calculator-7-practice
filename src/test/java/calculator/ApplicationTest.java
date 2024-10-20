package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3;;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void moreThan10() {
        assertSimpleTest(() -> {
            run("//[];\\n10[20],30;40");
            assertThat(output()).contains("결과 : 100");
        });
    }

    @Test
    void numberDelimiter() {
        assertSimpleTest(() -> {
            run("//3;\\n1323334");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void useSquareBrackets() {
        assertSimpleTest(() -> {
            run("//[];\\n1[2],3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void emptySpaceTest() {
        assertSimpleTest(() -> {
            run("// \\n1 2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
