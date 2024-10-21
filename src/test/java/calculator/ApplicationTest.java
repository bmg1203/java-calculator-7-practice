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

    // 정상 케이스
    @Test
    void 빈문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_한번() {
        String[] inputStrings = {"1,2", "1:2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 기본_구분자_두번() {
        String[] inputStrings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 6");
            });
        }
    }

    @Test
    void 구분자가_앞뒤에_있을_경우() {
        String[] inputStrings = {":1:2", "1:2:", ",1:2", "1:2,", ",1,2", "1,2,"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputStrings);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 커스텀_구분자가_앞뒤에_있을_경우() {
        String[] inputStrings = {"//;\\n;1;2", "//;\\n1;2;", "//;\\n;1:2", "//;\\n1:2;", "//;@\\n;@1,2",
                "//;@\\n1,2;@"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputStrings);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 두자리_숫자() {
        String[] inputStrings = {"11:22", "10:23", "23:10", "9:24", "1,32", "33,0"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputStrings);
                assertThat(output()).contains("결과 : 33");
            });
        }
    }

    @Test
    void 커스텀_구분자_한개_2번_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_여러글자_1번_사용() {
        assertSimpleTest(() -> {
            run("//;@\\n1;@2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_모두_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자가_특수문자1() {
        String[] inputStrings = {"//#\\n1#2", "//!\\n1!2", "//@\\n1@2", "//\\$\\n1$2", "//%\\n1%2", "//\\^\\n1^2",
                "//&\\n1&2", "//\\*\\n1*2", "//\\(\\n1(2", "//\\)\\n1)2", "//-\\n1-2", "//\\+\\n1+2", "//=\\n1=2",
                "//\\|\\n1|2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 커스텀_구분자가_특수문자2() {
        String[] inputStrings = {"//'\\n1'2", "//\"\\n1\"2", "//\\t\\n1\t2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 커스텀_구분자가_공백인_경우() {
        String[] inputStrings = {"// \\n1 2", "// \\n 1 2", "// \\n1 1 1", "// \\n1 1 1 "};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    // 에러 케이스
    @Test
    void 음수기호_포함() {
        String[] inputStrings = {"-1,2", "1,-2", "-1:2", "1:-2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class);
            });
        }
    }

    @Test
    void 잘못된_커스텀구분자() {
        String[] inputStrings = {"/;\\n1;2", "//;\\1;2", "\\n;//1;2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class);
            });
        }
    }

    @Test
    void 커스텀_구분자_여러글자_일부_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;@\\n1;2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자가_숫자인_경우() {
        String[] inputStrings = {"//0\\n102", "//1\\n112", "//9\\n192"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
