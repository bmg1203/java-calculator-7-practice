package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:6,4");
            assertThat(output()).contains("결과 : 13");
        });
    }
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    @Test
    void 빈_문자열_확인() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }
    @Test
    void 예외_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3,-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_기본_구분자_아닌_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4,2/5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_커스텀_구분자_아닌_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^\\n5%2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
