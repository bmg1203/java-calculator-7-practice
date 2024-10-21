package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//@\\n1,2@3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트2(){
        assertSimpleTest(()->{
            assertThrows(IllegalArgumentException.class,()->{
                run("//\\n1,2,3;4");
            });
            assertThrows(IllegalArgumentException.class,()->{
                run("//3\\n1,2,3,4");
            });
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
