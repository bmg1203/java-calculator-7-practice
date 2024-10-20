package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//'\\n1", "//\"\\n1", "//,\\n1", "//;\\n1", "//:\\n1", "//-\\n1", "//.\\n1", "//*\\n1", "//_\\n1",
            "//+\\n1", "//?\\n1", "//[\\n1", "//]\\n1", "//{\\n1", "//}\\n1"
            , "//(\\n1", "//)\\n1", "//|\\n1", "//^\\n1", "//$\\n1", "//!\\n1", "//@\\n1", "//#\\n1", "//&\\n1", "//`\\n1",
            "//~\\n1", "//<\\n1", "//>\\n1", "///\\n1", "//\\\\n1"
    })
    void 커스텀_구분자_양수와_단독_사용(String input) throws Exception {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 1");
        });
    }
}
