package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Disabled;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MyApplicationTest extends NsTest {
    @Test
    void escapeCode() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void flexibility() {
        assertSimpleTest(() -> {
            run("//--\\n2--3--5");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void newLine() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testWithoutAssertWhichPasses() {
        assertSimpleTest(() -> {
            run("//--\\n2--3--5"); //테스트 통과
        });
    }

    //@Disabled
    @Test
    void testWithoutAssertWhichFails() {
        assertSimpleTest(() -> {
            run("//--\n2--3--5"); //테스트 실패
        });
    }

    @Test
    void emptySeparator() {
        assertSimpleTest(() -> {
            run("//\\n1234");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void emptySeparatorWithException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n-1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
