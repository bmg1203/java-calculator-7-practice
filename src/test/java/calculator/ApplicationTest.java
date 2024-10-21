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
    void 예외_테스트_공백이_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른문자가_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅁ,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_오버플로우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9999999999999999999999,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자가_비어있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0이_들어가있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자가_숫자인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n3,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자가_기본구분자인_경우() {
        assertSimpleTest(() ->

                assertThatThrownBy(() -> runException("//,\\n3,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자가_2글자_이상인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//[]\\n3,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
