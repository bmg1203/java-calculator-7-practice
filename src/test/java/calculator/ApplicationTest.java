package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 숫자_추출() {
        String input = "1,2,3";
        int[] result = Application.extractNumbers(input, Application.separators);
        assertThat(result).contains(1, 2, 3);
    }

    @Test
    void 더하는_기능() {
        int[] input = {1, 2, 3};
        int result = Application.sum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
                run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_정규식_문자_사용() {
        assertSimpleTest(() -> {
            run("//.\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 형식에_맞지_않는_문자열1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aks3lii1ndm"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 형식에_맞지_않는_문자열2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2,3"))
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

    @Test
    void 빈문자열_테스트2() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_없음() {
        assertThatThrownBy(() -> runException("//\\n1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_이스케이프문자_사용() {
        assertSimpleTest(() -> {
            run("//\\t\\n1\\t2\\t3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_숫자_사용() {
        assertThatThrownBy(() -> runException("//3\\n13233"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 출력_형식() {
        assertSimpleTest(() -> {
            run("///\\n1/2,3:4");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
