package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용X() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 아무것도_없을_때_테스트() {
        assertSimpleTest(() -> {
            run("//\\\\n:,\\");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_백_슬래시() {
        assertSimpleTest(() -> {
            run("///\\\\n1\\2:3/4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 마이너스_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 없는_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1 2:4:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이전_테스트에_있는_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///\\\\n1\\2;5/4"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
