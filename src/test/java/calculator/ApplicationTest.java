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
    void 기본_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 하나의_피연산자만_사용() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 실수_사용() {
        assertSimpleTest(() -> {
            run("1.1:2:3");
            assertThat(output()).contains("결과 : 6.1");
        });
    }

    @Test
    void 커스텀_구분자와_실수_사용() {
        assertSimpleTest(() -> {
            run("//#\\n1.1#2#3");
            assertThat(output()).contains("결과 : 6.1");
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
    void 커스텀_구분자_1자_이상_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1;2ab3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_2개_이상_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n//@\\n1;2@3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 허용되지_않는_커스텀_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n1:2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자를_커스텀_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 지정하지_않은_커스텀_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자를_커스텀_구분자로_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 식별되지_않는_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1@2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연산할_숫자보다_더_많은_구분자_사용_예외_테스트() {
        assertSimpleTest(() -> {
                    assertThatThrownBy(() -> runException("1::3"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThatThrownBy(() -> runException("1:2:3:"))
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    void 인식되지_않는_커스텀_구분자로_사용_예외_메시지_테스트() {
        assertSimpleTest(() -> {
                    assertThatThrownBy(() -> runException("// \\n1 2 3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("해당 구분자( )는 커스텀 구분자로 사용할 수 없어요. (사유: 인식되지 않는 구분자) 다른 구분자를 사용해주세요.");
                    assertThatThrownBy(() -> runException("//\\\\n1\\2\\3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("해당 구분자(\\)는 커스텀 구분자로 사용할 수 없어요. (사유: 인식되지 않는 구분자) 다른 구분자를 사용해주세요.");
                }
        );
    }

    @Test
    void 수학적_기호를_커스텀_구분자로_사용_예외_메시지_테스트() {
        assertSimpleTest(() -> {
                    assertThatThrownBy(() -> runException("//+\\n1+2+3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("해당 구분자(+)는 커스텀 구분자로 사용할 수 없어요. (사유: 수학적 기호) 다른 구분자를 사용해주세요.");
                    assertThatThrownBy(() -> runException("//-\\n1-2-3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("해당 구분자(-)는 커스텀 구분자로 사용할 수 없어요. (사유: 수학적 기호) 다른 구분자를 사용해주세요.");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
