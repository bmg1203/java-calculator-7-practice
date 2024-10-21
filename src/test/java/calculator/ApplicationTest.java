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
    void 커스텀_구분자와_기본_구분자_혼용_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1,2;3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 값");
        });
    }

    @Test
    void 여러_커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//[;][&]\\n1;2&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백_포함된_숫자_테스트() {
        assertSimpleTest(() -> {
            run(" 1, 2 :3 ");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 단일_숫자_입력_테스트() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 숫자_0_처리_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("0,1,2"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양수 외에 불가. 다시 실행하시오.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
