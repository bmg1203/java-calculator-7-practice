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
    void 빈칸은_0으로_인식() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    void 공백은_0으로_인식(){
        assertSimpleTest(() -> {
            run("1:::::2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_기본_구분자_혼합_사용(){
        assertSimpleTest(() -> {
            run("//-\\n1:2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 예외_테스트_숫자는_양수만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:0:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_문자열은_양수와_구분자만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////;\n\n1//;2//;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_구분자_외_문자_존재() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////;\n\n1//;\n2//;\n4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
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
}
