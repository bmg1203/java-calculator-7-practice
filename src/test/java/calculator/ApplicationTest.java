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

    // build test
    @Test
    void empty() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // test 01 : comma
    @Test
    void comma() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    // test 02 : colon
    @Test
    void colon() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    // test 03 : colon & comma
    @Test
    void comma_colon() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    //test 04 : single number
    @Test
    void single_number() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void custom_delimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void custom_delimiter_mix() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void custom_delimiter_err() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2.3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
