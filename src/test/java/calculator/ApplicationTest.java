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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3"); // 기본 구분자 쉼표 사용
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자와_기본구분자_혼합테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3"); // 커스텀 구분자와 기본 구분자 혼합
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 비정상적_입력_테스트() {
        assertSimpleTest(() -> {
            run("1,a,3"); // 비정상적 입력
            assertThat(output()).contains("Non-numeric value found");
        });
    }

    @Test
    void 다양한_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3"); // 커스텀 구분자 # 사용
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("//***\\n4***5***6"); // 커스텀 구분자 *** 사용
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
