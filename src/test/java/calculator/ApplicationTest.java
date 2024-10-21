package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void customDelimiterUsage() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void testException() {
        assertSimpleTest(() -> {
            run("-1,2,3");
            assertThat(output()).contains("음수는 허용되지 않습니다");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
